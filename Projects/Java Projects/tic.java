import java.io.*;
import java.util.*;

class tic {
    static HashSet<Integer> ur_set = new HashSet<>();
    static HashSet<Integer> comp_set = new HashSet<>();

    public static void main(String[] args) {
        char[][] g_boader = {
                { ' ', '|', ' ', '|', ' ' },
                { '-', '|', '-', '|', '-' },
                { ' ', '|', ' ', '|', ' ' },
                { '-', '|', '-', '|', '-' },
                { ' ', '|', ' ', '|', ' ' }
        };
        print_board(g_boader);
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Enter values from 1-9: ");
            int user_position = sc.nextInt();
            while (ur_set.contains(user_position) || comp_set.contains(user_position)) {
                System.out.println();
                System.out.print("Retry, Enter values from 1-9: ");
                user_position = sc.nextInt();
            }
            p_holder(g_boader, user_position, "You");
            String res = check_winner();
            if (res.length() > 0) {
                System.out.println(res);
                break;
            }
            int cmp_pos = gen_random();
            while (ur_set.contains(cmp_pos) || comp_set.contains(cmp_pos)) {
                cmp_pos = gen_random();
            }
            p_holder(g_boader, cmp_pos, "Comp");
            res = check_winner();
            if (res.length() > 0) {
                System.out.println(res);
                break;
            }

        }

    }

    static String check_winner() {
        HashSet<Integer> r1 = new HashSet<>();
        r1.add(1);
        r1.add(2);
        r1.add(3);
        HashSet<Integer> r2 = new HashSet<>();
        r2.add(4);
        r2.add(5);
        r2.add(6);
        HashSet<Integer> r3 = new HashSet<>();
        r3.add(7);
        r3.add(8);
        r3.add(9);
        HashSet<Integer> c1 = new HashSet<>();
        c1.add(1);
        c1.add(4);
        c1.add(7);
        HashSet<Integer> c2 = new HashSet<>();
        c2.add(2);
        c2.add(5);
        c2.add(8);
        HashSet<Integer> c3 = new HashSet<>();
        c3.add(3);
        c3.add(6);
        c3.add(9);
        HashSet<Integer> d1 = new HashSet<>();
        d1.add(1);
        d1.add(5);
        d1.add(9);
        HashSet<Integer> d2 = new HashSet<>();
        d2.add(3);
        d2.add(5);
        d2.add(7);

        HashSet<HashSet> set = new HashSet<HashSet>();
        set.add(r1);
        set.add(r2);
        set.add(r3);
        set.add(c1);
        set.add(c2);
        set.add(c3);
        set.add(d1);
        set.add(d2);
        for (HashSet c : set) {
            if (ur_set.containsAll(c)) {
                return "YOU WON";
            } else if (comp_set.containsAll(c)) {
                return "YOU LOST";
            }
        }
        if (ur_set.size() + comp_set.size() == 9) {
            return "DRAW";
        }
        return "";
    }

    static int gen_random() {
        int max = 9;
        int min = 1;
        int range = max - min + 1;
        int res = (int) (Math.random() * range) + min;
        return res;
    }

    static void print_board(char[][] g_boader) {
        for (int r = 0; r < g_boader.length; r++) {
            for (int c = 0; c < g_boader[0].length; c++) {
                System.out.print(g_boader[r][c]);
            }
            System.out.println();
        }
    }

    static void p_holder(char[][] g_boader, int pos, String user) {
        char symb = 'X';
        if (user.equals("You")) {
            symb = 'X';
            ur_set.add(pos);
        } else if (user.equals("Comp")) {
            symb = 'O';
            comp_set.add(pos);
        }
        switch (pos) {
            case 1:
                g_boader[0][0] = symb;
                break;
            case 2:
                g_boader[0][2] = symb;
                break;
            case 3:
                g_boader[0][4] = symb;
                break;
            case 4:
                g_boader[2][0] = symb;
                break;
            case 5:
                g_boader[2][2] = symb;
                break;
            case 6:
                g_boader[2][4] = symb;
                break;
            case 7:
                g_boader[4][0] = symb;
                break;
            case 8:
                g_boader[4][2] = symb;
                break;
            case 9:
                g_boader[4][4] = symb;
                break;
            default:
                System.out.println("Invalid Input");
        }
        print_board(g_boader);
    }
}
