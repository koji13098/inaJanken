import java.util.Scanner;
import java.util.Random;

public class JankenOrigin {
  public static void main(String[] args) {
    System.out.println("何回戦にしますか？１〜１０の数字を入力してください");
    // 対戦回数を決める
    Scanner scannerHowManyFight = new Scanner(System.in);
    int howManyFight = Integer.parseInt(scannerHowManyFight.nextLine());
    // 11以上の数字が入力された場合の処理
    if (howManyFight > 10) {
      System.out.println("入力できるのは１〜１０までです　最初からやり直してください");
    } else {
      // 自分の手の入力用Scannerクラスのインスタンスを作成
      Scanner scannerPlayerHand = new Scanner(System.in);
      // 乱数作成用の変数randを作成
      Random rand = new Random();
      // コンピューターが出す手用の配列を作成
      String[] cpuChoice = { "グー", "チョキ", "パー" };
      // 勝敗用の素材
      final String win = "あなたの勝ちです";
      final String lose = "あなたの負けです";
      final String draw = "あいこです";
      // 勝敗数カウント用の変数
      int countWin = 0;
      int countLose = 0;
      int countDraw = 0;
      // じゃんけんの処理
      for (int i = 1; i <= howManyFight; i++) {
        System.out.println(i + "回戦目");
        // 乱数を作成
        int randNum = rand.nextInt(3);
        // 自分の手を入力させる
        System.out.println("グー・チョキ・パーのどれかを入力してください");
        String input = scannerPlayerHand.nextLine();
        // 自分とコンピューターが何を出したかのメッセージ
        System.out.println("あなたは" + input + "を入力しました");
        System.out.println("コンピュータの手は" + cpuChoice[randNum] + "です");
        // 勝敗の処理
        // グーの場合
        if (input.equals("グー") && cpuChoice[randNum].equals("チョキ")) {
          System.out.println(win);
          countWin++;
        } else if (input.equals("グー") && cpuChoice[randNum].equals("パー")) {
          System.out.println(lose);
          countLose++;
          // チョキの場合
        } else if (input.equals("チョキ") && cpuChoice[randNum].equals("パー")) {
          System.out.println(win);
          countWin++;
        } else if (input.equals("チョキ") && cpuChoice[randNum].equals("グー")) {
          System.out.println(lose);
          countLose++;
          // パーの場合
        } else if (input.equals("パー") && cpuChoice[randNum].equals("グー")) {
          System.out.println(win);
          countWin++;
        } else if (input.equals("パー") && cpuChoice[randNum].equals("チョキ")) {
          System.out.println(lose);
          countLose++;
          // あいこの場合
        } else {
          System.out.println(draw);
          countDraw++;
        }
        // 現在の対戦結果
        System.out.println("現在" + countWin + "勝" + countLose + "敗" + countDraw + "分けです");

      }
      // 最終結果の表示
      if (countWin > countLose) {
        System.out.println(countWin + "勝" + countLose + "敗であなたの勝利です");
      } else if (countWin < countLose) {
        System.out.println(countWin + "勝" + countLose + "敗であなたの敗北です");
      } else {
        System.out.println(countWin + "勝" + countLose + "敗で引き分けです");
      }
      scannerPlayerHand.close();
    }
    scannerHowManyFight.close();
  }
}
