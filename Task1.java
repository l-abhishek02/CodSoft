import java.util.*;


class GameInterface
{
    int GuessNumber = 0;
    int Range = 0;
    int Turns = 0;
    float SuccessRate = 0.0f;

    GameInterface()
    {
        System.out.println("\n\n=========================================================");
        System.out.println("\n\tWELCOME TO NUMBER GUESSING GAME.\n");
        System.out.println("=========================================================");
    }

    public void Game()
    {
        Scanner sc = new Scanner(System.in);
        Random rc = new Random();
        GuessNumber = rc.nextInt(Range)+1;

        while(true)
        {
            System.out.println("\n\n----------------------------");
            System.out.println("Guess the Correct Number : ");
            try
            {
            int userinput = sc.nextInt();
            Turns--;



            if(userinput==GuessNumber)
            {
                SuccessRate = (float)((float)(Turns)/(float)Range)*(float)100;
                System.out.println("Hurrah You Guessed it Correctly\n");
                System.out.println("\tSCORE");
                System.out.println("----------------------------\n");
                System.out.println("Turn Required : "+(Range-Turns)+"\n");
                System.out.println("SuccessRate : "+SuccessRate+"%\n");

                
                System.out.println("----------------------------\n\n");
                break;
            }
            else if(userinput>Range)
            {
                System.out.println("You Are Searching out of range\n----------------------------\nTurns Remaining are : "+this.Turns);
                System.out.println("----------------------------");
            }
            else if(userinput>GuessNumber)
            {
                System.out.println("Your Number is Bigger\n----------------------------\nTurns Remaining are : "+this.Turns);
                System.out.println("----------------------------");
            }
            else if(userinput<GuessNumber)
            {
                System.out.println("Your Number is Smaller\n----------------------------\nTurns Remaining are : "+this.Turns);
                System.out.println("----------------------------");
            }
            }catch(Exception eobj){System.out.println("Invalid Parameter\n");}
            
            if(Turns==0)
            {
                System.out.println("\n----------------------------");
                System.out.println("You Lose !!!!\nNo Turns Left.\nBetter Luck Next Time.");
                System.out.println("----------------------------");
                break;
            }
        }
    }

    public int Menu()
    {
        Scanner sc = new Scanner(System.in);
        int choice;
        System.out.println("\n\n----------------------\n\tMENU\n----------------------");
        System.out.println(" 1. Play\n 2. Quit\n");
        System.out.println("Select Choice : ");
        try
        {
        choice = sc.nextInt();
        if(choice>2 || choice<0)
        {
            return -1;
        }
        else
        {
            return choice;
        }
        }catch(Exception eobj){}
        return -1;
    }

    public int SetRange()
    {
        Scanner sc = new Scanner(System.in);
        try
        {
        System.out.println("Enter Range : ");
        this.Range = sc.nextInt();
        this.Turns = this.Range;
        System.out.println("\n----------------------------\n\n\nGame Range is Between 1 to "+Range+"\n");
        System.out.println("Computer Selected a Number.\nGUESS IT..");
        }catch(Exception eobj){return -1;}
        return 1;
    }

}


class Task1
{
    public static void main(String arg[])
    {
        int ichoice = 0;
        int ires = 0;
        int Range = 0;
        Scanner sc = new Scanner(System.in);
        GameInterface gobj = new GameInterface();
        
        while(true)
        {
            ichoice = gobj.Menu();
            if(ichoice == 1)
            {
                ires = gobj.SetRange();

                if(ires == 1)
                {
                    gobj.Game();
                }
                else if(ires == -1)
                {
                    System.out.println("\nInvalid Parameter !!!.\n");
                }
            }

            else if(ichoice == 2)
            {
                System.out.println("----------------------------\n");
                System.out.println("Thank You For Playing Our Game.\n");
                System.out.println("----------------------------");
                break;
            }
            else
            {
                System.out.println("\nInvalid Parameter.!!!\n");
            }

        }
    
    }

}