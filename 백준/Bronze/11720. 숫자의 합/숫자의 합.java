import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 빠른 I/O 설정
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine()); // 숫자 개수 (실제로 사용하지 않아도 됨)
        String digits = br.readLine(); // 숫자 문자열
        
        int sum = 0;
        // 각 문자를 숫자로 변환하여 합산
        for (int i = 0; i < digits.length(); i++) {
            sum += digits.charAt(i) - '0'; // char를 int로 변환: '5' - '0' = 5
        }
        
        System.out.println(sum);
        br.close(); // BufferedReader 닫기 (리소스 해제)
    }
}
