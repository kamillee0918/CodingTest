import java.io.*;

/**
 * 문제: 별 찍기 - 2(https://www.acmicpc.net/problem/2439)
 * 
 * 입력: N (1 ≤ N ≤ 100)
 * 출력: 첫째 줄부터 N번째 줄 까지 차례대로 별을 출력한다.
 * 
 * 예제 입력 1:
 * 5
 * 
 * 예제 출력 1:
 *     *
 *    **
 *   ***
 *  ****
 * *****
 * 
 * @author @kamillee0918
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // 입력 스트림 설정 (Scanner 대비 빠른 I/O)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine()); // 줄 수 입력
        StringBuilder sb = new StringBuilder();  // 출력 문자열 구성용

        for (int i = 0; i < n; i++) {
            sb.setLength(0); // StringBuilder 초기화 (새 객체 생성 방지)
            
            // 공백 출력: (n-i-1)개
            for (int j = 0; j < n - i - 1; j++) {
                sb.append(' ');
            }
            
            // 별 출력: (i+1)개
            for (int j = 0; j < i + 1; j++) {
                sb.append('*');
            }
            
            sb.append('\n');
            bw.write(sb.toString()); // 한 줄씩 버퍼에 기록
        }
        
        bw.flush(); // 버퍼 내용 출력
        bw.close(); // BufferedWriter 닫기 (리소스 해제)
        br.close(); // BufferedReader 닫기 (리소스 해제)
    }
}   
