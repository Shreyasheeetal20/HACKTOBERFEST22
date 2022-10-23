class sample
 {
    double triangle()
    {
      int base=7;
      int height=4;
      double area=(0.5*(base*height));
      return area;
    }
}
class TriangleArea
{

    public static void main(String[] args)
    {
      double x= new sample().triangle();
       System.out.println(x);
    }
 }
