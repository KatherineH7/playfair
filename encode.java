import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class encode
{
  public static void main(String[] args)
  {
    File inFile = null;
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
  }
}
