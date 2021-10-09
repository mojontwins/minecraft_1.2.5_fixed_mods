import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Packager {
  String getName();
  
  String getVersion();
  
  String[] getClasses();
  
  String[] getBaseDirectories();
  
  String[] getForcedClasses() default {""};
  
  String getObfRelocationDir() default "";
}


/* Location:              C:\Users\na_th_an\Downloads\NotEnoughItems-Client 1.3.zip!\Packager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */