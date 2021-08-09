package cryptography;

public class Decryptor 
{

    static String decrypt(String src, String key)
    {
        String level2 = level2(src, key);
        return level1(level2, key);
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
        int i,j, len1, temp, r, c;
        int color[];
        
        StringBuffer enc = new StringBuffer();
        color = ColorManager.getColor(key);
        
        len1 = src.length();
        
        for(i =0, j =0; i < len1; i++, j=(j+1)%color.length) 
        {
            temp = ((int)src.charAt(i) - color[j] + 256)%256;
            r = temp/16;
            c = temp%16;
            enc.append((char)merge(r,c));
        }
        return enc.toString();
    }
    
    private static int merge(int nibble1, int nibble2)
    {
        return (nibble1 << 4) | nibble2;
    }
}
