package cryptography;

public class Encryptor 
{
    static String encrypt(String src, String key)
    {
        String level1 = level1(src, key);
        return level2(level1, key);
    }
    
    private static String level1(String src, String key)
    {
        int i, len1, len2;
        StringBuffer enc = new StringBuffer();
        len1 = src.length();
        len2 = key.length();
        
        for(i =0 ; i < len1; i++)
            enc.append((char)((int)src.charAt(i) ^ (int)key.charAt(i%len2)));
        
        return enc.toString();
    }
    
    private static String level2(String src, String key)
    {
        int i,j, len1, len2, r, c;
        int color[];
        
        StringBuffer enc = new StringBuffer();
        color = ColorManager.getColor(key);
        
        len1 = src.length();
        
        for(i =0, j =0; i < len1; i++, j=(j+1)%color.length) 
        {
            r = getHigherNibble(src.charAt(i));
            c = getLowerNibble(src.charAt(i));
            enc.append((char)((color[j] + r *16 + c ) % 256));
        }
        return enc.toString();
    }
    
    private static int getHigherNibble(int x)
    {
        return (x & 240)>>4;  //240:11110000
    }
    
    private static int getLowerNibble(int x)
    {
        return x & 15;  //15:00001111
    }    
}
