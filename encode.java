import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class encode
{
  public static void main(String[] args)
  {
    File inFile = null;
    String message = "";
    if (0 < args.length)
    {
      inFile = new File(args[0]);
    }
    else
    {
    System.err.println("Invalid arguments count:" + args.length);
    System.exit(0);
    }

      BufferedReader br = null;

      try
      {
        String sCurrentLine;

        br = new BufferedReader(new FileReader(inFile));

        while ((sCurrentLine = br.readLine()) != null)
          {
            message += sCurrentLine;
            System.out.println(sCurrentLine);
          }

       }

       catch (IOException e)
        {
          e.printStackTrace();
        }

        finally
        {
          try
          {
            if (br != null)br.close();
          }
          catch (IOException ex)
          {
            ex.printStackTrace();
          }
        }



        message = message.toUpperCase();
        message = message.replaceAll("\\p{Punct}", "");
        message = message.replaceAll("\\d","");
        System.out.println(message);

        ArrayList<Character> ch = new ArrayList<Character>();
        for (int i = 0; i < message.length(); i++)
        {
            ch.add(message.charAt(i));
        }

        for (int x = 0; ch.get(x).equals(ch.get(x+1)) && x % 2 == 0; x++)
          {
            int y = ch.size() - 1;
            ch.add(ch.get(y));
            while (y > x + 2)
            {
              ch.set(y,ch.get(y-1));
              y--;
              ch.set(x+1, 'X');
            }
          }

        for (int z = 0; z < ch.size(); z++)
        {
            if (z % 2 == 0)
              System.out.print(ch.get(z));
            else
              System.out.print(ch.get(z) + " ");
        }

  }
}
