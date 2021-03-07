public class Planet{
   //instance variables
   private double mass; //the planet's mass
   private Vector2D pos;//the planet's position
   private Vector2D vel;//the planet's velocity
   private String image;//filename of the planet's image
   
   //static variables
   private static double G = 6.67408E-11; //gravity constant
   public Planet(double mass, double pos_x, double pos_y, double vel_x, double vel_y, String image){
      /*Constructor. Initialize a new Planet object.
      Input:
         double mass: the planet's mass, kg
         double pos_x: the x-component of initial position, m
         double pos_y: the y-component of initial position, m
         double vel_x: the x-component of initial velocity, m
         double vel_y: the y-component of initial velocity, m
      Output:
         this: a new Planet object with the given mass,
         position, velocity
      Ex.
      Planet p = new Planet(100.0, 200.0, 0.0, 0.0, 200.0)
      p is a planet with mass 100, at (200, 0) moving up with
      v = (0, 200)
      */
      this.mass = mass;
      this.pos = new Vector2D(pos_x, pos_y);
      this.vel = new Vector2D(vel_x, vel_y);
      this.image = image;
   }
   public double getMass(){
      /*Accessor. Return this Planet's mass
      Input:
         this: a Planet object
      Output:
         return: this Planet's mass
      Ex.
      Planet p = new Planet(100.0, 200.0, 0.0, 0.0, 200.0)
      p.getMass() -> 100.0
      */
      return this.mass;
   }
   public Vector2D getPos(){
      /*Accessor. Return this Planet's position
      Input:
         this: a Planet object
      Output:
         return: this Planet's position
      Ex.
      Planet p = new Planet(100.0, 200.0, 0.0, 0.0, 200.0)
      Vector2D pos = p.getPos()
      pos.toString() -> "(200.0, 0.0)"
      */
      return this.pos;
   }
   public Vector2D getVel(){
      /*Accessor. Return this Planet's velocity
      Input:
         this: a Planet object
      Output:
         return: this Planet's velocity
      Ex.
      Planet p = new Planet(100.0, 200.0, 0.0, 0.0, 200.0)
      Vector2D vel = p.getVel()
      vel.toString() -> "(0.0, 200.0"
      */
      return this.vel;
  }
  public Vector2D displacement(Planet that){
      /*Return the displacement from this Planet to that Planet
      Input:
         this: a Planet object
         that: another Planet object
      Output:
         return: a Vector2D representing the displacement from
         this to that
      Ex.
      Planet p1 = new Planet(100.0, 200.0, 0.0, 0.0, 200.0)
      Planet p2 = new Planet(50.0, 0.0, 150.0, 150.0, 0.0)
      p1.getPos() -> (200.0, 0.0)
      p2.getPos() -> (0.0, 150.0)
      p1.displacement(p2) -> (-200.0, 150.0)
      p2.displacement(p1) -> (200.0, -150.0)
      */
      double displace1 = this.pos.getX() - that.pos.getX();
      double displace2 = this.pos.getY() - that.pos.getY();
      return new Vector2D(displace1, displace2);
  }
  public double distance(Planet that){
      /*Return the distance from this Planet to that Planet
      Input:
         this: a Planet object
         that: another Planet object
      Output:
         return: a double representing the distance from this to that
      Ex.
      Planet p1 = new Planet(100.0, 200.0, 0.0, 0.0, 200.0)
      Planet p2 = new Planet(50.0, 0.0, 150.0, 150.0, 0.0)
      p1.getPos() -> (200.0, 0.0)
      p2.getPos() -> (0.0, 150.0)
      p1.distance(p2) -> 250.0
      p2.distance(p1) -> 250.0
      */
      double displace1sq = Math.pow(this.pos.getX() - that.pos.getX(), 2);
      double displace2sq = Math.pow(this.pos.getY() - that.pos.getY(), 2);
      return Math.sqrt(displace1sq + displace2sq);
   }
   public double gravityMag(Planet that){
      /*Return the magnitude of the force of gravity between
      this Planet and that Planet
      Input:
         this: a Planet object
         that: another Planet object
      Output:
         return: the magnitude of the force of gravity
         between this planet and that planet
      Ex.
      Planet p1 = new Planet(100.0, 200.0, 0.0, 0.0, 200.0)
      Planet p2 = new Planet(50.0, 0.0, 150.0, 150.0, 0.0)
      p1.gravityMag(p2) -> 5.339264E-12
      p2.gravityMag(p1) -> 5.339264E-12
      */
      double gmm = this.G * this.mass * that.mass;
      double d2 = Math.pow(this.distance(that), 2);
      return gmm/d2;
   }
   public Vector2D gravityVec(Planet that){
      /*Return a 2D vector representing the force of gravity
      from that Planet on this Planet
      Input:
         this: a Planet object
         that: another Planet object  
      Output:
         return: a Vector2D representing the force of gravity
         from that on this
      Ex.
      Planet p1 = new Planet(100.0, 200.0, 0.0, 0.0, 200.0)
      Planet p2 = new Planet(50.0, 0.0, 150.0, 150.0, 0.0)
      p1.gravityVec(p2) -> (-4.2714112E-12, 3.2035584E-12)
      p2.gravityVec(p1) -> (4.2714112E-12, -3.2035584E-12)
      */
      //this.gravityMag(that);
      Vector2D vec = new Vector2D(this.displacement(that).x, this.displacement(that).y);
      Vector2D vecUnit = vec.unit();
      double vecX = vecUnit.x * this.gravityMag(that);
      double vecY = vecUnit.y * this.gravityMag(that); 
      return new Vector2D(vecX, vecY);
      
  }
  public void draw(){
      /*Draw this Planet in StdDraw
      Input:
         this: a Planet object
      Output:
         StdDraw: draw this Planet to StdDraw
      Ex.
      Planet p = new Planet(100.0, 0.0, 0.0, 0.0, 0.0, "earth.gif")
      p.draw() -> draws earth.gif at (0.0, 0.0)
      */
      StdDraw.picture(this.pos.x, this.pos.y, this.image);
  }
  public void step(Vector2D fNet, double dt){
      /*Update this Planet's position and velocity given a
      net force acting over a certain timestep
      Input:
         this: a Planet object
         Vector2D Fnet: the net force acting on this Planet
         double dt: the timestep over which the net force acts
      Output: none
      Side Effects: this.pos and this.vel are updated
      Ex.
      Planet p = new Planet(2.0, 0.0, 0.0, 1.0, 0.0)
      p.toString() -> m=2.0, pos=(0.0, 0.0), vel=(1.0, 0.0)
      Vector2D fNet = new Vector2D(1.0, 0.0)
      p.step(fNet, 0.5)
      p.toString() ->  m=2.0, pos=(0.5, 0.0), vel=(1.25, 0.0)
      */
      double xForce = fNet.x;
      double yForce = fNet.y;
      double xAcc = xForce * this.mass;
      double yAcc = yForce * this.mass;
      this.pos.x += this.vel.x * dt;
      this.pos.y += this.vel.y * dt;
      this.vel.x += xAcc * dt;
      this.vel.y += yAcc * dt;
      
  }
  public Vector2D netForce(Planet[] those){
      /*Calculate the net force acting on this Planet from those
      Planets
      Input:
         this: a Planet object
         those: an array of other Planets
      Output:
         return: a Vector2D representing the net force acting on
         this Planet from those Planets
      Ex.
      Planet p1 = new Planet(100.0, 200.0, 0.0, 0.0, 200.0)
      Planet p2 = new Planet(50.0, 0.0, 100.0, 100.0, 0.0)
      Planet p3 = new Planet(75.0, 150.0, 150.0, -150.0, -150.0)
      Planet[] those = new Planet[2]
      those[0] = p2
      those[1] = p3
      p1.gravityVec(p2) -> (-5.96947862E-12, 2.98473931E-12)
      p1.gravityVec(p3) -> (-6.33158822E-12, 1.89947646E-11)
      p1.netForce(those) ->(-1.23010668E-11, 2.19795039E-11)
      */
      double xCounter = 0;
      double yCounter = 0;
      for (int i = 0; i < those.length; i++){
         xCounter += those[i].pos.getX();
      }
      for (int i = 0; i < those.length; i++){
         yCounter += those[i].pos.getY();
      }
      return new Vector2D(xCounter, yCounter);
   }

}
   
   