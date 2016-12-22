package start;

import java.security.SecureRandom;
import java.util.Random;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

class AESKeyGeneration {
	
	static String logo = "  ______   ________   ______         __    __                                                 \n" +
			" /      \\ /        | /      \\       /  |  /  |                                                \n" +
			"/$$$$$$  |$$$$$$$$/ /$$$$$$  |      $$ | /$$/   ______   __    __                             \n" +
			"$$ |__$$ |$$ |__    $$ \\__$$/       $$ |/$$/   /      \\ /  |  /  |                            \n" +
			"$$    $$ |$$    |   $$      \\       $$  $$<   /$$$$$$  |$$ |  $$ |                            \n" +
			"$$$$$$$$ |$$$$$/     $$$$$$  |      $$$$$  \\  $$    $$ |$$ |  $$ |                            \n" +
			"$$ |  $$ |$$ |_____ /  \\__$$ |      $$ |$$  \\ $$$$$$$$/ $$ \\__$$ |                            \n" +
			"$$ |  $$ |$$       |$$    $$/       $$ | $$  |$$       |$$    $$ |                            \n" +
			"$$/   $$/ $$$$$$$$/  $$$$$$/        $$/   $$/  $$$$$$$/  $$$$$$$ |                            \n" +
			"                                                        /  \\__$$ |                            \n" +
			"                                                        $$    $$/                             \n" +
			"  ______                                                 $$$$$$__      __                     \n" +
			" /      \\                                                     /  |    /  |                    \n" +
			"/$$$$$$  |  ______   _______    ______    ______    ______   _$$ |_   $$/   ______   _______  \n" +
			"$$ | _$$/  /      \\ /       \\  /      \\  /      \\  /      \\ / $$   |  /  | /      \\ /       \\ \n" +
			"$$ |/    |/$$$$$$  |$$$$$$$  |/$$$$$$  |/$$$$$$  | $$$$$$  |$$$$$$/   $$ |/$$$$$$  |$$$$$$$  |\n" +
			"$$ |$$$$ |$$    $$ |$$ |  $$ |$$    $$ |$$ |  $$/  /    $$ |  $$ | __ $$ |$$ |  $$ |$$ |  $$ |\n" +
			"$$ \\__$$ |$$$$$$$$/ $$ |  $$ |$$$$$$$$/ $$ |      /$$$$$$$ |  $$ |/  |$$ |$$ \\__$$ |$$ |  $$ |\n" +
			"$$    $$/ $$       |$$ |  $$ |$$       |$$ |      $$    $$ |  $$  $$/ $$ |$$    $$/ $$ |  $$ |\n" +
			" $$$$$$/   $$$$$$$/ $$/   $$/  $$$$$$$/ $$/        $$$$$$$/    $$$$/  $$/  $$$$$$/  $$/   $$/ ";
	byte[] skey = new byte[1000];
	String skeyString;
	static byte[] raw;

	public AESKeyGeneration() {
		generateSymmetricKey();
	}

	void generateSymmetricKey() {
		try {
			Random r = new Random();
			int num = r.nextInt(10000);
			String knum = String.valueOf(num);
			byte[] knumb = knum.getBytes();
			skey = getRawKey(knumb);
			skeyString = new String(skey);
			System.out.println("AES Symmetric key = " + skeyString);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private static byte[] getRawKey(byte[] seed) throws Exception {
		KeyGenerator kgen = KeyGenerator.getInstance("AES");
		SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
		sr.setSeed(seed);
		kgen.init(128, sr); // 192 and 256 bits may not be available
		SecretKey skey = kgen.generateKey();
		raw = skey.getEncoded();
		return raw;
	}

	public byte[] getSessionKey() {
		return raw;
	}

	public static void main(String args[]) {
		System.out.println(logo);
		System.out.println("By : Kansas");
		System.out.println(" ");

		new AESKeyGeneration();
	}
}