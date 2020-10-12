public class decode
{
  public static void main(String[] args)
  {
    File plaintext = null;
    File keytext = null;
    String message = "";
    String key = "";

    if (0 < args.length)
    {
        plaintext = new File(args[0]);
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

        br = new BufferedReader(new FileReader(plaintext));

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



}
