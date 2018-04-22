#include <iostream>
#include <string>
#include <cmath>
using namespace std;
/**写的比我短，所以采纳为标程,by CHENG Zheng**/
//90ms
int cas;
string buf,str,temp;
bool comp()
{
    int a=0,b=0;
    for (int i=0;i<str.length();++i)
        a=a*10 + (str[i]-'0');
    for (int i=0;i<temp.length();++i)
        b=b*10 + (temp[i]-'0');
    return b>a;
}
int main()
{
    freopen("D.in","r",stdin);
    freopen("D.out","w",stdout);
    int i,len;
    string sp;
    cin>>cas;
    while (cas--)
    {
        cin>>buf;
        sp="";
        len=buf.length();
        str=buf[0];
        for (i=1;i<len;++i)
        {
            temp+=buf[i];
            if (comp()) //temp > str
            {
                cout<<sp<<str;
                sp=",";
                str=temp;
                temp="";
            }
        }
        if (!comp())
            str+=temp;
        cout<<sp<<str;
        cout<<endl;
        temp=str="";
    }

    return 0;
}
