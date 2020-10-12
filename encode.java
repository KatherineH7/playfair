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
            if (message.charAt(i) != 'J')
              ch.add(message.charAt(i));
            else
              ch.add('I');
        }

        for (int x = 0; x < ch.size() - 1; x++)
          {
            if ((ch.get(x) == ch.get(x + 1)) && (x % 2 == 0))
              {
                ArrayList<Character> placeholder = new ArrayList<>(ch);
                ch.set(x+1, 'X');
                for (int y = x + 2; y < ch.size(); y++)
                {
                  ch.set(y, placeholder.get(y-1));
                }
                ch.add(placeholder.get(placeholder.size() - 1));
              }
          }

        if (ch.size() % 2 == 1 && ch.get(ch.size() - 1) != 'Z')
          ch.add('Z');
        if (ch.size() % 2 == 1 && ch.get(ch.size() - 1) == 'Z')
          ch.add('X');

        for (int z = 0; z < ch.size(); z++)
        {
            if (z % 2 == 0)
              System.out.print(ch.get(z));
            else
              System.out.print(ch.get(z) + " ");
        }

  }
}
