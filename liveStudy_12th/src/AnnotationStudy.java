import java.lang.reflect.Method;

//@interface MyMarkerAnnotation{
//
//}
//// @MyMarkerAnnotation
//
//@interface MySingleAnnotation{
//    int value() default 0;
//}
//// @MySingleAnnotation(value=10)
//
//@interface MyMultiAnnotation{
//    int value1() default 0;
//    String value2() default "Hello";
//}
//// @MyMultiAnnotation(value1=10, value2="World")

public class AnnotationStudy {

    @MyAnnotation(value=3, str="Hello World!!!")
    public void HelloWorld(){
        System.out.println("HelloWord!");
    }

    public static void main(String[] args) throws NoSuchMethodException {
        AnnotationStudy rs = new AnnotationStudy();
        Method m=rs.getClass().getMethod("HelloWorld");

        MyAnnotation anno = m.getAnnotation(MyAnnotation.class);

        for(int i=0; i<anno.value(); i++){
            System.out.println(anno.str());
        }

    }
}
