public class Universe{
   private Planet[] planets;  //holds all the Planets
   private double radius;     //how big the Universe is
   private static String background = "starfield.jpg";
  
   public Universe(int nPlanets, double radius){
      /*Constructor. Initialize a new Universe object
      Input:
         int nPlanets: the number of Planets in this Universe
         double radius: the physical scale of this Universe
      Output:
         this: a Universe object with space for nPlanets Planets
      Ex.
      Universe u = new Universe(3, 1000.0)
      */
      this.planets = new Planet[nPlanets];
      this.radius = radius;
   }
   public void setPlanet(int index, Planet p){
      /*Mutator. Store Planet p at index i in this.planets
      Input:
         this: a Universe object
         int index: the index of where to store p
         Planet p: the Planet you would like to store
      Output: None
      Side Effects: this.planets[index] now holds p
      Ex.
      Planet p1 = new Planet(100.0, 200.0, 0.0, 0.0, 200.0)
      Planet p2 = new Planet(50.0, 0.0, 100.0, 100.0, 0.0)
      Universe u = new Universe(2, 1000.0)
      u.setPlanet(0, p1)
      u.setPlanet(1, p2)
      */
      planets[index] = p;
   }
   public Planet getPlanet(int index){
      /*Accessor. Get the Planet p at index i in this.planets
      Input:
         this: a Universe object
         int index: the index of the Planet you would like
      Output:
         return: the Planet at that index
      Ex.
      Planet p1 = new Planet(100.0, 200.0, 0.0, 0.0, 200.0)
      Planet p2 = new Planet(50.0, 0.0, 100.0, 100.0, 0.0)
      Universe u = new Universe(2, 1000.0)
      u.setPlanet(0, p1)
      u.setPlanet(1, p2)
      u.getPlanet(0)->m=100.0,pos=(200.0, 0.0),vel=(0.0, 200.0)
      */
      return planets[index];
   }
   public Planet[] except(int index){
      /*Return an array of all the Planets in this Universe
      except the Planet at index
      Input:
         this: a Universe object
         int index: the Planet to exclude
      Output:
         return: a new Planet[] containing all the Planets in
         this Universe except the Planet at index
      Ex.
      Planet p1 = new Planet(100.0, 200.0, 0.0, 0.0, 200.0)
      Planet p2 = new Planet(50.0, 0.0, 100.0, 100.0, 0.0)
      Planet p3 = new Planet(75.0, 150.0, 150.0, -150.0, -150.0)
      Universe u = new Universe(3, 1000.0)
      u.setPlanet(0, p1)
      u.setPlanet(1, p2)
      u.setPlanet(2, p3)
      u.except(0) -> [p2, p3] <--not what you'll actually see
      u.except(1) -> [p1, p3]
      u.except(2) -> [p1, p2]
      */
      Planet[] planetsExcept = new Planet[this.planets.length - 1];
      //Planet experimental[] = this.planets;
      /*experimental[index] = null;
      for (int i = 0; i < this.planets.length; i++){
         if (experimental[i] != null){
            if (i > index){
               planetsExcept[i] = experimental[i-1];
            }
            else{
               planetsExcept[i] = experimental[i];
            }
         }
      }*/
      /*if (index == 0) {
         for (int i = 1; i < planetsExcept.length + 1; i++){
            planetsExcept[i-1] = this.planets[i];
         }
         
      }
      else{
      for (int i = 0; i < index; i++){
         planetsExcept[i] = this.planets[i];
      }*/
      int counter = 0;
      for (int i = 0; i < planetsExcept.length+1; i++){
         if (i != index){
         planetsExcept[counter] = this.planets[i];
         counter++;
         }
      }
      
      return planetsExcept;
   }
   public void draw(){
      /*Draw the Universe and all the Planets in it
      Input:
         this: a Universe object
      Output:
         StdDraw: clears the screen, draws the background,
         then draws each Planet in the Universe.
      Ex.
      Planet p1 = new Planet(1, 0.1, 0.1, 0, 0, "saturn.gif")
      Planet p2 = new Planet(1, 0.5, 0.5, 0, 0, "jupiter.gif")
      Planet p3 = new Planet(1, 0.9, 0.9, 0, 0, "venus.gif")
      Universe u = new Universe(3, 1.0)
      u.setPlanet(0, p1)
      u.setPlanet(1, p2)
      u.setPlanet(2, p3)
      u.draw() -> draws three planets on a starfield
      */
     
      //clear the screen
      StdDraw.clear();
      //draw the background
      StdDraw.picture(0.0, 0.0, background, 2*this.radius, 2*this.radius);
      //draw each Planet in this Universe
      //YOUR CODE GOES HERE
      for (int i = 0; i < this.planets.length; i++){
         planets[i].draw();
      }
   }
   public void step(double dt){
      /*Step the Planets in this Universe forward by a
      timestep dt
      Input:
         this: a Universe with Planets in it
         double dt: the timestep to step forward
      Output: none
      Side Effects: the Planets in the Universe have all been
      updated using Newton's Laws
      */
      
      for (int i = 0; i < planets.length; i++){
         Planet planet = planets[i];
         Planet[] planetsExcept = this.except(i);
         Vector2D forces = new Vector2D(0, 0);
         //planet.step(forces, dt);
         for (int j = 0; j < planets.length-1; j++){
            //Vector2D grav = planet.gravityVec(planetsExcept[j]);
            //forces.add(planet.netForce(planetsExcept));
            Vector2D force = planet.netForce(planetsExcept);
            forces.x += force.x;
            forces.y += force.y;
            //forces.add(force);
            //StdOut.println(planet.netForce(planetsExcept));
            //forces.add(grav); //use netforce
            /*forces.x += Planet.gravityVec.x;
            forces.y += PVec.y;*/
            //planet.step(force, dt);
         }
         StdOut.println(forces);
         planet.step(forces, dt);
      }
   }
   public static void main(String[] args){
      /*Setup a Universe from file*/
      //get the timestep from args
      double dt = Double.parseDouble(args[0]);
      //get the number of Planets
      int numPlanets = StdIn.readInt();
      //get the radius of the Universe
      double radius = StdIn.readDouble();
      //setup the Universe
      Universe u = new Universe(numPlanets, radius);
      StdDraw.setScale(-radius, radius);
      //add Planets to the Universe
      for(int i = 0; i < numPlanets; i++){
         double pos_x = StdIn.readDouble();
         double pos_y = StdIn.readDouble();
         double vel_x = StdIn.readDouble();
         double vel_y = StdIn.readDouble();
         double mass = StdIn.readDouble();
         String image = StdIn.readString();
         Planet p = new Planet(mass, pos_x, pos_y, vel_x, vel_y, image);
         u.setPlanet(i, p);
      }
      StdDraw.enableDoubleBuffering();
      while(true){
         u.draw(); //draw the universe
         u.step(dt); //step the universe forward
         StdDraw.show(); //show the universe
      }

   } 
}
