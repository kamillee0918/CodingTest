import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        // 빠른 I/O 설정
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        String s = br.readLine();
        
        // a~z 위치 저장 배열 (-1로 초기화)
        int[] pos = new int[26];
        Arrays.fill(pos, -1);
        
        // 문자열 순회하며 첫 등장 위치 기록
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a'; // 'a'=0, 'b'=1, ..., 'z'=25
            if (pos[idx] == -1) {        // 첫 등장일 때만 기록
                pos[idx] = i;
            }
        }
        
        // 결과 출력
        for (int i = 0; i < 26; i++) {
            sb.append(pos[i]);
            if (i < 25) sb.append(' ');
        }
        
        System.out.println(sb);
        br.close();
    }
}
