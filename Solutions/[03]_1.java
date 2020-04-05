import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.security.MessageDigest;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String base = br.readLine();
		
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		byte[] hash = md.digest(base.getBytes("UTF-8"));
		StringBuffer result = new StringBuffer();
		
		for (int i = 0; i < hash.length; i++) {
			String hex = Integer.toHexString(0xff & hash[i]);
			if (hex.length() == 1) result.append('0');
			result.append(hex);
		}
		
		System.out.println(result.toString());
	}

}
