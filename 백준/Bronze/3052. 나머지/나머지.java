import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 빠른 I/O 설정
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 나머지는 0~41만 가능 → 고정 크기 배열로 중복 체크 (HashSet보다 메모리 효율적)
        boolean[] remainder = new boolean[42];
        
        // 10개 숫자 읽으며 나머지 체크
        for (int i = 0; i < 10; i++) {
            int num = Integer.parseInt(br.readLine());
            remainder[num % 42] = true;
        }
        
        // 서로 다른 나머지 개수 카운트
        int count = 0;
        for (int i = 0; i < 42; i++) {
            if (remainder[i]) count++;
        }
        
        System.out.println(count);
        br.close();
    }
}
