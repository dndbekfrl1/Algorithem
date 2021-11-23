/**
 * 유사회문 - 한 문자 삭제
 * 
 * **/

#include <iostream>
#include <string>
#include <cstring>

using namespace std;

bool semiPalindrome(string str, int left, int right)
{
    while (left < right)
    {
        if (str[left] == str[right])
        {
            left += 1;
            right -= 1;
        }
        else
        {
            return false;
        }
    }
    return true;
}

int Solve(int left, int right, string str)
{
    while (left < right)
    {

        if (str[left] == str[right])
        {
            left += 1;
            right -= 1;
        }
        else
        {
            bool res1 = semiPalindrome(str, left + 1, right);
            bool res2 = semiPalindrome(str, left, right - 1);

            if (res1 == true || res2 == true)
            {
                return 1;
            }
            else
            {
                return 2;
            }
        }
    }
    return 0;
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    int T;
    cin >> T;

    for (int i = 0; i < T; i++)
    {
        string str;
        cin >> str;

        int left = 0;
        int right = str.size() - 1;

        int answer = Solve(left, right, str);

        cout << answer << endl;
    }
}