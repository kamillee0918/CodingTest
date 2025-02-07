import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public int[][] solution(int[][] data, String ext, int valExt, String sortBy) {
        List<int[]> qualified = new ArrayList<>();

        int extIndex;
        switch (ext) {
            case "code":
                extIndex = 0;
                break;
            case "date":
                extIndex = 1;
                break;
            case "maximum":
                extIndex = 2;
                break;
            case "remain":
                extIndex = 3;
                break;
            default:
                extIndex = -1;
        }

        for (int[] row : data) {
            if (row[extIndex] <= valExt) {
                qualified.add(row);
            }
        }

        int sortIndex;
        switch (sortBy) {
            case "code":
                sortIndex = 0;
                break;
            case "date":
                sortIndex = 1;
                break;
            case "maximum":
                sortIndex = 2;
                break;
            case "remain":
                sortIndex = 3;
                break;
            default:
                sortIndex = -1;
        }

        Collections.sort(qualified, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[sortIndex], b[sortIndex]);
            }
        });

        int[][] result = new int[qualified.size()][];
        for (int i = 0; i < qualified.size(); i++) {
            result[i] = qualified.get(i);
        }

        return result;
    }
}
