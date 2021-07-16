package application;

class Ceasars
{
    String pt="";
    char t;
    String ct="";
    public String encrypt2(String text,int n)
    {
        int len;
        len=text.length();
        char ch1[]=text.toCharArray();
        char ch3;
        for(int i=0;i<len;i++)
        {   
            if(ch1[i]==(char)32)
            {   
                ct=ct+ch1[i];             
            }
            else
            {
                if(Character.isUpperCase(ch1[i]))
            {
                ch3=(char)(((int)ch1[i]+(n-65))%26+65);
                ct=ct+ch3;
            }
            else
            {
                ch3=(char)(((int)ch1[i]+(n-97))%26+97);
                ct=ct+ch3;
            }
            }
        }
        return ct;
    }
    public String decrypt2(String cip,int n)
    {
        char t;
        char ch4[]=cip.toCharArray();
        String pt="";
        int len2=cip.length();
        for(int i=0;i<len2;i++)
        {
           if(ch4[i]==(char)32)
            {
                pt=pt+ch4[i];
            }
            else
            {
                if(Character.isUpperCase(ch4[i]))
            {
                t=(char)(((int)ch4[i]-(n-65))%26+65);
                pt=pt+t;
            }
            else
            {
                t=(char)(((int)ch4[i]-(n+97))%26+97);
                pt=pt+t;
            }
            }
        }
        return pt;
    }

}

