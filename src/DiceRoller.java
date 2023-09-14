import javax.swing.*;
import java.util.Random;

/**
 * @author RatingE10
 */
public class DiceRoller
{
    //The whole result of the roll, this is just so I can loop and ask for multiple dice, if necessary.
    static int rollResult;
    static Random gen = new Random();
    static int rollNumber = 0;


    public static void main(String[] args)
    {
        //This boolean exists solely to facilitate the while loop so the user can keep rolling.
        boolean keepRolling = true;
        while (keepRolling)
        {
            infoAndDisplay();
            int result = JOptionPane.showConfirmDialog(null, "Would you like to roll anymore dice?", "Continue?", JOptionPane.YES_NO_OPTION);
            if(result == 1)
            {
                keepRolling = false;
            }
        }
        //Bringing back the gay!
        boolean gay = true;
        while(gay)
        {
            try
            {
                rollResult += Integer.parseInt(JOptionPane.showInputDialog(null, "Please add up any modifiers you have to the dice roll and input the total here. (Input 0 for none)"));
                gay = false;
            }
            catch (Exception e)
            {
                JOptionPane.showMessageDialog(null, "Please input a valid number. If you don't have any modifiers, please input 0.");
            }
        }
        JOptionPane.showMessageDialog(null, "Your result is " + rollResult + ".");
        System.exit(0);

    }

    /**
     * Actually rolling the dice now.
     * @param diceType Name is self-explanatory.
     */
    public static void diceRoller(Object diceType) {
        int increment;
        switch (diceType.toString()) {
            case "Coin":
                if (gen.nextInt(2) == 0) {
                    JOptionPane.showMessageDialog(null, "Heads.");
                } else {
                    JOptionPane.showMessageDialog(null, "Tails.");
                }
                break;
            case "d4":
                increment = gen.nextInt(4) + 1;
                rollResult += increment;
                //Printing out the dice for each case allows for the user to determine why the hell their number is so shitty.
                System.out.println("d4 = " + increment);
                break;
            case "d6":
                increment = gen.nextInt(6) + 1;
                rollResult += increment;
                System.out.println("d6 = " + increment);
                break;
            case "d8":
                increment = gen.nextInt(8) + 1;
                rollResult += increment;
                System.out.println("d8 = " + increment);
                break;
            case "d10":
                increment = gen.nextInt(10) + 1;
                rollResult += increment;
                System.out.println("d10 = " + increment);
                break;
            case "d12":
                increment = gen.nextInt(12) + 1;
                rollResult += increment;
                System.out.println("d12 = " + increment);
                break;
            case "d20":
                increment = gen.nextInt(20) + 1;
                rollResult += increment;
                System.out.println("d20 = " + increment);
                break;
            case "Advantage":
                int aRoll1 = gen.nextInt(20) + 1;
                int aRoll2 = gen.nextInt(20) + 1;
                rollResult = Math.max(rollResult, Math.max(aRoll1, aRoll2));
                System.out.println("d20 = " + aRoll1 + ", " + aRoll2);
                break;
            case "Disadvantage":
                int dRoll1 = gen.nextInt(20) + 1;
                int dRoll2 = gen.nextInt(20) + 1;
                rollResult = Math.min(dRoll1, dRoll2);
                System.out.println("d20 = " + dRoll1 + ", " + dRoll2);
                break;
            default:
                JOptionPane.showMessageDialog(null, "The program has broken somehow. Please... uh... excuse me while I look under the hood.");
                System.exit(0);

        }
    }
    public static void infoAndDisplay()
    {
        Object diceType;
        String [] options = {"Coin", "d4", "d6", "d8", "d10", "d12", "d20", "Advantage", "Disadvantage"};
        diceType = JOptionPane.showInputDialog(null, "Please pick the dice that you want to roll.", "Dice Type Picker", JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        //Automatically assuming the user is gay.
        boolean gay = true;
        int diceNumber = 0;
        while(gay)
        {
            try {
                diceNumber = Integer.parseInt(JOptionPane.showInputDialog(null, "Please input how many dice of this type you would like to roll."));
                //If they don't, they lose the gay.
                gay = false;
            } catch (Exception e)
            {
                //If user doesn't input a number or inputs a decimal, they stay gay.
                JOptionPane.showMessageDialog(null, "Please input a valid number. (Whole numbers, please)");
            }
        }

        for(int i = 0; i < diceNumber; i++)
        {
            System.out.println("Roll " + (rollNumber + 1) + " ");
            diceRoller(diceType);
            rollNumber ++;
       }
        JOptionPane.showMessageDialog(null, "Your dice have been rolled.");
    }

}


