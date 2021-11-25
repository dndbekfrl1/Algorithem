#include <iostream>
#include <string>
#include <cstring>
#include <vector>

using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    string Input;
    cin >> Input;
    int idx;
    vector<string> croatian = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

    for (int i = 0; i < croatian.size(); i++)
    {
        while (true)
        {
            idx = Input.find(croatian[i]);
            if (idx == string::npos)
            {
                break;
            }
            Input.replace(idx, croatian[i].length(), "#");
        }
    }
    cout << Input.length();
}