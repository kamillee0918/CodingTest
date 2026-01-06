import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 빠른 I/O 설정
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine()); // 정수 개수
        StringTokenizer st = new StringTokenizer(br.readLine()); // 공백 기준 토큰 분리
        
        // 첫 번째 값으로 min/max 초기화 (Integer.MAX/MIN_VALUE 대신 실제 값 사용)
        int first = Integer.parseInt(st.nextToken());
        int min = first;
        int max = first;
        
        // 나머지 값들과 비교하며 min/max 갱신
        for (int i = 1; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (num < min) min = num;
            if (num > max) max = num;
        }
        
        System.out.println(min + " " + max);
        br.close(); // BufferedReader 닫기 (리소스 해제)
    }
}