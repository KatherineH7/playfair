import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class encode
{
  public static void main(String[] args)
  {
    File ciphertext = null;
    File keytext = null;
    String message = "";
    String key = "";

    if (0 < args.length)
    {
        ciphertext = new File(args[0]);
        keytext = new File(args[1]);
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

        br = new BufferedReader(new FileReader(ciphertext));

        while ((sCurrentLine = br.readLine()) != null)
          {
            message += sCurrentLine;
          }

          BufferedReader br2 = null;

         br2 = new BufferedReader(new FileReader(keytext));

         while ((sCurrentLine = br2.readLine()) != null)
           {
             key += sCurrentLine;
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

        for (int k = 0; k < ch.size(); k++)
        {
            if (k % 2 == 0)
              System.out.print(ch.get(k));
            else
              System.out.print(ch.get(k) + " ");
        }

        char[][] cipherKey = new char[5][5];
        int z = 0;
        for (int x = 0; x < 5; x++)
        {
          for (int y = 0; y < 5; y++)
          {
            cipherKey[x][y] = key.charAt(z);
            z++;
          }
        }

        System.out.println(Arrays.deepToString(cipherKey));

        System.out.print("Final: ");
        for (int x = 0; x < ch.size(); x = x + 2)
        {
          char a = ch.get(x);
          char b = ch.get(x + 1);
          int q = 0;
          int m = 0;
          int n = 0;
          int o = 0;
          int p = 0;
          for (int i = 0; i < 5; i++)
          {
            for (int j = 0; j < 5; j++)
            {
                if (a == cipherKey[i][j])
                {
                  m = i;
                  n = j;
                  q++;
                }
                if (b == cipherKey[i][j])
                {
                  o = i;
                  p = j;
                  q++;
                }
            }
          }
          if (q > 1)
          {
            if (m != o && n != p)
            {
              System.out.print(cipherKey[m][p]);
              System.out.print(cipherKey[o][n]);
              System.out.print(" ");
            }
            else
            {
              if (m == o)
              {
                System.out.print(cipherKey[m + 1][n]);
                System.out.print(cipherKey[o + 1][p]);
                System.out.print(" ");
              }
              else
              {
                System.out.print(cipherKey[m][n + 1]);
                System.out.print(cipherKey[o][p + 1]);
                System.out.print(" ");
              }
            }
          }
        }



  }
}
