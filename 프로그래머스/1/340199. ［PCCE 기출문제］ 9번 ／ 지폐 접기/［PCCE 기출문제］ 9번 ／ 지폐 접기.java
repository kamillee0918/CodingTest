class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        int walletMax = Math.max(wallet[0], wallet[1]);
        int walletMin = Math.min(wallet[0], wallet[1]);
        
        int billWidth = bill[0];
        int billHeight = bill[1];
        
        while (true) {
            int billMax = Math.max(billWidth, billHeight);
            int billMin = Math.min(billWidth, billHeight);
            
            if (billMax <= walletMax && billMin <= walletMin) {
                break;
            }
            
            if (billWidth >= billHeight) {
                billWidth = billWidth / 2;
            } else {
                billHeight = billHeight / 2;
            }
            
            answer++;
        }
        
        return answer;
    }
}