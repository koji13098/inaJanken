import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Janken {

  // 勝敗の処理
  private static String judgeHand(String hand1, String hand2) {
    String result = "";

    // グーの場合
    if (hand1.equals("グー") && hand2.equals("チョキ")) {
      result = "win";
    } else if (hand1.equals("グー") && hand2.equals("パー")) {
      result = "lose";
      // チョキの場合
    } else if (hand1.equals("チョキ") && hand2.equals("パー")) {
      result = "win";
    } else if (hand1.equals("チョキ") && hand2.equals("グー")) {
      result = "lose";
      // パーの場合
    } else if (hand1.equals("パー") && hand2.equals("グー")) {
      result = "win";
    } else if (hand1.equals("パー") && hand2.equals("チョキ")) {
      result = "lose";
      // あいこの場合
    } else {
      result = "draw";
    }
    return result;
  }

  public static void main(String[] args) {

    // コンピューターが出す手用の配列を作成
    final List<String> JANKEN_HAND = new ArrayList<>(Arrays.asList("グー", "チョキ", "パー"));
    // 勝敗用の素材
    final String WIN = "あなたの勝ちです";
    final String LOSE = "あなたの負けです";
    final String DRAW = "あいこです";

    // 勝敗数カウント用の変数
    int countWin = 0;
    int countLose = 0;
    int countDraw = 0;

    while (true) {

      System.out.println("何回戦にしますか？１〜１０の数字を入力してください。0で終了します。");

      // 対戦回数を決める
      int howManyFight = 0;
      Scanner scannerHowManyFight = new Scanner(System.in);
      try {
        howManyFight = scannerHowManyFight.nextInt();
        // 0未満11以上の数字が入力された場合の処理
        if (0 > howManyFight || howManyFight > 10) {
          throw new Exception("入力できるのは１〜１０までです");
        }
      } catch (Exception e) {
        System.out.println(e.getMessage());
        System.out.println("入力値が不正です。最初からやり直してください");
        return;
      }

      // 0が入力されたら終了
      if (howManyFight == 0) {
        System.out.println("終了します");
        return;
      }

      // 乱数作成用の変数randを作成
      Random rand = new Random();

      // 自分の手の入力用Scannerクラスのインスタンスを作成
      Scanner scannerPlayerHand = new Scanner(System.in);
      // じゃんけんの処理
      for (int i = 1; i <= howManyFight; i++) {
        System.out.println(i + "回戦目");
        // 乱数を作成
        int randNum = rand.nextInt(3);

        // 自分の手を入力させる
        System.out.println("グー・チョキ・パーのどれかを入力してください");
        String input = "";
        try {
          input = scannerPlayerHand.nextLine();
          if (!JANKEN_HAND.contains(input)) {
            throw new Exception();
          }
        } catch (Exception e) {
          System.out.println(e.getMessage());
          System.out.println("入力値が不正です。最初からやり直してください");
          return;
        }

        // 自分とコンピューターが何を出したかのメッセージ
        System.out.println("あなたは" + input + "を入力しました");
        System.out.println("コンピュータの手は" + JANKEN_HAND.get(randNum) + "です");

        // 勝敗の処理
        String resultJudgeHand = judgeHand(input, JANKEN_HAND.get(randNum));
        if (resultJudgeHand == "win") {
          System.out.println(WIN);
          countWin++;
        } else if (resultJudgeHand == "lose") {
          System.out.println(LOSE);
          countLose++;
        } else if (resultJudgeHand == "draw") {
          System.out.println(DRAW);
          countDraw++;
        }

        // 現在の対戦結果
        System.out.println("現在" + countWin + "勝" + countLose + "敗" + countDraw + "分けです");
        System.out.println("--------------------------");
      }

      // 最終結果の表示
      System.out.println("---------勝敗結果---------");
      System.out.print(countWin + "勝" + countLose + "敗で");
      if (countWin > countLose) {
        System.out.println("あなたの勝利です");
      } else if (countWin < countLose) {
        System.out.println("あなたの敗北です");
      } else {
        System.out.println("引き分けです");
      }
      System.out.println("--------------------------");
    }
  }
}
