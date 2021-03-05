public class Vector2D{   
   double x; //the x component
   double y; //the y component
  
   public Vector2D(double x, double y){
      this.x = x;
      this.y = y;
  }
public String toString(){
      /*Return a String representation of this vector
      Input:
         this: a vector
      Output:
         return: a String representing this vector
      Side Effects: none */
      return "(" + this.x + ", " + this.y + ")";
   }
public boolean equals(Vector2D that){
      /*Check if this equals that
      Input:
         this: a Vector2D
         that: another Vector 2D
      Output:
         return: true if this is equivalent to that, i.e. if
                 both x and y components are equal
      Side Effects: none */
   if (this.x == that.x && this.y == that.y) return true;
   else return false;
   }
   public Vector2D clone(){
      /*Returns a cloned copy of this Vector2D
      Input:
         this: a Vector
      Output:
         return: a new Vector2D that is a copy of this
      Side Effects: none */
      double x = this.x;
      double y = this.y;
      return new Vector2D(x, y);
   }
   public double getX(){
      /*Accessor. Return the x component of this
      Input:
         this: a Vector2D
      Output:
         return: the x-component of this
      Ex.
      Vector2D vec = new Vector2D(1.0, 2.0)
      vec.getX() -> 1.0
      */
      return this.x;
   }

   public double getY(){
      /*Accesor. Return the y component of this
      Input:
         this: a Vector2D
      Output
         return: the y-component of this
      Ex.
      Vector2D vec = new Vector2D(1.0, 2.0)
      vec.getY() -> 2.0
      */
      return this.y;
   }
   public void setX(double x){
      /*Mutator. Set the x-component of this to x
      Input:
         this: a Vector2D
         double x: the new x-component of this
      Output: none
      Side Effects: this.x is now x
      Ex.
      Vector2D vec = new Vector2D(1.0, 2.0)
      vec.setX(3.0)
      vec.toString() -> (3.0, 2.0)
      */
      this.x = x;
   }

   public void setY(double y){
      /*Mutator. Set the y-component of this to y
      Input:
         this: a Vector2D
         double y: the new y-component
      Output: none
      Side Effects: this.y is now y
      Ex.
      Vector2D vec = new Vector2D(1.0, 2.0)
      vec.setY(4.0)
      vec.toString() -> (1.0, 4.0)
      */
      this.y = y;
   }
   public Vector2D add(Vector2D that){
      /*Add this to that
      Input:
         this: a Vector2D
         that: another Vector2D
      Output:
         return: a new Vector2D representing this + that
      Ex.
      Vector2D vec1 = new Vector2D(1.0, 2.0)
      Vector2D vec2 = new Vector2D(-1.0, 3.0)
      Vector2D plus = vec1.add(vec2)
      plus.toString() -> (0.0, 5.0)
      */
      return new Vector2D(this.x + that.x, this.y + that.y);
   }
   public Vector2D subtract(Vector2D that){
      /*Subtract this from that
      Input:
         this: a Vector2D
         that: another Vector2D
      Output:
         return: a new Vector2D representing this - that
      Ex.
      Vector2D vec1 = new Vector2D(1.0, 2.0)
      Vector2D vec2 = new Vector2D(2.0, 1.0)
      Vector2D minus = vec1.subtract(vec2)
      minus.toString() -> (-1.0, 1.0)
      */
      return new Vector2D(this.x - that.x, this.y - that.y);

}
   public Vector2D multiply(double scalar){
      /*Multiply this Vector2D by a scalar
      Input:
         this: a Vector2D
         double scalar: a scalar to multiply this
      Output:
         return: a new Vector2D representing scalar*this
      Ex.
      Vector2D vec = new Vector2D(1.0, 2.0)
      Vector2D times = vec.multiply(2.0)
      times.toString() -> (2.0, 4.0)
      */
      return new Vector2D(this.x * scalar, this.y * scalar);
}
   public Vector2D divide(double scalar){
      /*Divide this Vector2D by a scalar
      Input:
         this: a Vector2D
         double scalar: the scalar to divide by
      Output:
         return: a new Vector2D representing this/scalar
      Ex.
      Vector2D vec = new Vector2D(1.0, 2.0)
      Vector2D div = vec.divide(2.0)
      div.toString() -> (0.5, 1.0)
      */
      return new Vector2D(this.x / scalar, this.y / scalar);
}
   public double abs(){
      /*Return the absolute value or magnitude of this Vector2D
      Input:
         this: a Vector2D
      Output:
         return: the absolute value, a.k.a the magnitude of this
      Ex.
      Vector2D vec = new Vector2D(-3.0, 4.0)
      vec.abs() -> 5.0
      */
   return Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2));
}
   public Vector2D unit(){
      /*Return a unit vector in the same
      direction as this
      Input:
         this: a Vector2D
      Output:
         return: a Vector2D pointing in the same direction
         as this but with length = 1
      Ex.
      Vector2D vec = new Vector2D(3.0, 4.0)
      Vector2D vecUnit = vec.unit()
      vecUnit.toString() -> (0.6, 0.8)
      */
      return new Vector2D(this.x/this.abs(), this.y/this.abs());
}
   public double dot(Vector2D that){
      /*Calculate the dot product of this and that
      Input:
         this: a Vector2D
         that: another Vector2D
      Output:
         return: this dot that
      Ex.
      Vector2D vec1 = new Vector2D(0.0, 5.0)
      Vector2D vec2 = new Vector2D(1.0, 2.0)
      vec1.dot(vec2) -> 10.0
      */
      return this.x*that.x + this.y*that.y;
}
}