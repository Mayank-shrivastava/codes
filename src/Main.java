import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        // String name = String.format("Hello %s", "World");
        // System.out.println(name);

        // StringBuilder sb = new StringBuilder("mayank");
        // System.out.println(sb.reverse());

        String pattern = "a*b";
        String text = "aaaab";
        boolean matches = Pattern.matches(pattern, text);
        System.out.println(matches);
    }
}