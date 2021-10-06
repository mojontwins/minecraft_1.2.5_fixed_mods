import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface MLProp {
  String name() default "";
  
  String info() default "";
  
  double min() default -InfinityD;
  
  double max() default InfinityD;
}


/* Location:              C:\Users\na_th_an\Downloads\ModLoader 1.2.5.zip!\MLProp.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */