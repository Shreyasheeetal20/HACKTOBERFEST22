#include <Iostream>
using namespace std;

vector<int> Smallest(vector<int> heights, int n)
{
     vector<int> ps(n);
     stack<int> st;

     for (int i = 0; i < n; i++)
     {
          while (!st.empty() && heights[st.top()] >= heights[i])
          {
               st.pop();
          }

          if (st.empty())
          {
               ps[i] = -1;
          }
          else
          {
               ps[i] = st.top();
          }

          st.push(i);
     }

     return ps;
}

vector<int> newSmallest(vector<int> heights, int n)
{
     vector<int> ns(n);
     stack<int> st;

     for (int i = n - 1; i >= 0; i--)
     {
          while (!st.empty() && heights[st.top()] >= heights[i])
          {
               st.pop();
          }

          if (st.empty())
          {
               ns[i] = -1;
          }
          else
          {
               ns[i] = st.top();
          }

          st.push(i);
     }

     return ns;
}

int area(vector<int> heights)
{
     int n = heights.size();

     vector<int> ps(n);
     vector<int> ns(n);

     ps = Smallest(heights, n);
     ns = newSmallest(heights, n);

     int max_ans = 0;

     for (int i = 0; i < n; i++)
     {
          int curr = (ns[i] - ps[i] - 1) * heights[i]; // Main Formula
          max_ans = max(max_ans, curr);
     }

     return max_ans;
}
int main()
{
     vector<int> heights{4, 6, 8, 2, 5, 7, 9};
     // heights.push_back(1);
     // heights.push_back(2);
     // heights.push_back(3);

     // int n = heights.size();
     // cout << n;
     cout << heights[2];
     cout << "The area: " << area(heights) << endl;

     return 0;
}
