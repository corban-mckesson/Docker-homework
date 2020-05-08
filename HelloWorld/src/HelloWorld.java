import java.util.Map;
import java.util.Properties;


public class HelloWorld{
	public static void main(String args[]){
		System.out.println("Hello world");
		System.out.println("---------------------Environment vars--------------------");
		Map<String, String> enviorntmentVars  = System.getenv();
        enviorntmentVars.entrySet().forEach(System.out::println);
	}
}