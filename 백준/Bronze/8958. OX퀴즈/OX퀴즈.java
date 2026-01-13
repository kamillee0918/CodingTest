import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 빠른 I/O 설정
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int t = Integer.parseInt(br.readLine()); // 테스트 케이스 수
        
        for (int i = 0; i < t; i++) {
            String s = br.readLine();
            int score = 0;  // 총점
            int combo = 0;  // 연속 O 카운트
            
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == 'O') {
                    combo++;         // 연속 O 증가
                    score += combo;  // 현재 콤보만큼 점수 추가
                } else {
                    combo = 0;       // X면 콤보 리셋
                }
            }
            
            sb.append(score).append('\n');
        }
        
        System.out.print(sb);
        br.close();
    }
}
