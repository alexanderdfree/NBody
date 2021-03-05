public class Universe{
   private Planet[] planets;  //holds all the Planets
   private double radius;     //how big the Universe is
  
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
      planet[] planetsExcept[] = new planetsExcept[Planets.length - 1];
      
      for (int i = 0; i < index; i++){
         planetsExcept[i] = Planets[i];
      }
      for (int i = index; i < planetsExcept.length; i++){
         planetsExcept[i] = Planets[i-1];
      }
      return planetsExcept[];
   }
   

