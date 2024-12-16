package fp.dam.java.unidad3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	static ArrayList<String> m1(String s) {
		ArrayList<String> l = new ArrayList<>();
		StringBuilder aux = new StringBuilder();
		int i=1;
		while (i < s.length()) {
			aux.append(s.charAt(i - 1));
			while (i < s.length() && s.charAt(i) == s.charAt(i - 1)) {
				aux.append(s.charAt(i));
				i++;
			}
			if (aux.length() > 1)
				l.add(aux.toString());
			aux.setLength(0);
			i++;
		}
		return l;
	}
	
	/* solución alternativa */
//	static ArrayList<String> m1(String s) {
//		ArrayList<String> l = new ArrayList<>();
//		StringBuilder aux = new StringBuilder();
//		int i=0;
//		int n = s.length() - 1;
//		while (i < n) {
//			aux.append(s.charAt(i));
//			while (s.charAt(i) == s.charAt(i + 1)) {
//				i++;
//				aux.append(s.charAt(i));
//			}
//			if (aux.length() > 1)
//				l.add(aux.toString());
//			aux.setLength(0);
//			i++;
//		}
//		return l;
//	}
	
	static ArrayList<String> m2(String s) {
		ArrayList<String> l = new ArrayList<>();
		Matcher m = Pattern.compile("(.)\\1+").matcher(s);
		while (m.find())
			l.add(m.group());
		return l;
	}
	
	static Integer m3a(int [][] m) {
		if (m.length < 3 || m[0].length < 3)
			return null;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i <= m.length - 3; i++)
			for (int j = 0; j <= m[i].length - 3; j++) {
				int suma = 0;
				for (int k = i; k < i + 3; k++)
					for (int l = j; l < j + 3; l++)
						suma += m[k][l];
				if (suma > max)
					max = suma;
			}
		return max;
	}
	
	static int[][] m3b(int tipo) {
		switch (tipo) {
		case 1:
			return crearTablero(8, 8, 10);
		case 2:
			return crearTablero(16, 16, 40);
		case 3:
			return crearTablero(16, 30, 99);
		default:
			return null;
		}
	}
	
	static Random r = new Random();
	
	static int[][] crearTablero(int fil, int col, int minas) {
		int [][] tablero = new int[fil][col];
		while (minas > 0) {
			int f = r.nextInt(fil);
			int c = r.nextInt(col);
			if (tablero[f][c] != -1) {
				tablero[f][c] = -1;
				for (int i = f - 1; i <= f + 1; i++)
					for (int j = c - 1; j <= c + 1; j++)
						if (i >= 0 && i < fil && j >= 0 && j < col && tablero[i][j] != -1)
							tablero[i][j]++;
				minas--;
			}
		}
		return tablero;
	}
	
	/* solución alternativa */
//	static int[][] crearTablero(int fil, int col, int minas) {
//		int [][] tablero = new int[fil][col];
//		while (minas > 0) {
//			int f = r.nextInt(fil);
//			int c = r.nextInt(col);
//			if (tablero[f][c] != -1) {
//				tablero[f][c] = -1;
//				for (int i = f - 1; i <= f + 1; i++)
//					for (int j = c - 1; j <= c + 1; j++)
//						try {
//							if (tablero[i][j] != -1)
//								tablero[i][j]++;
//						} catch (ArrayIndexOutOfBoundsException e) {
//						}
//				minas--;
//			}
//		}
//		return tablero;
//	}
	
	public static void main(String[] args) {
		int [][] tablero = m3b(1);
		for (int [] f: tablero)
		System.out.println(Arrays.toString(f));
	}
}
