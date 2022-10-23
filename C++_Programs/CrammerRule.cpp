//its a program that implements crammers rule and solve given pair of equations
// Coded by Sourav ( github ---> SRV332003 )
// Date 20/10/22
#include <iostream>
#include <cstdio>
using namespace std;
float det3(float a1,float a2,float a3,float b1,float b2,float b3,float c1,float c2,float c3){
    return (a1*b2*c3)+(a2*b3*c1)+(a3*b1*c2)-(a3*b2*c1)-(a2*b1*c3)-(a1*b3*c2);
}
float det2(float a1,float a2,float b1,float b2){
    return (a1*b2)-(a2*b1);
}
int main(){
    int ord,ans=-404;
    cout<<endl<<"--------------------------------------------------------------------------------"<<endl;
        cout<<"Welcome to Equation Solver\nYou can solve 2 eq with 2 var and 3 eq with 3 var only.\nTO exit enter eq. number=0\nTo back after entering no. of eq. enter 4 zeros with space between them\n";
    cout<<"--------------------------------------------------------------------------------"<<endl<<endl;
	while(1){
		cout<<endl<<"--------------------------------"<<endl;
        cout<<"Enter number of equations(2 or 3): "; cin>>ord;getchar();
        cout<<"--------------------------------"<<endl<<endl;
		if(ord<=0){
			return 0;
		}
		if(ord==3){
            
			float a1,a2,a3,a4,b1,b2,b3,b4,c1,c2,c3,c4,d,d1,d2,d3;
            float x,y,z;
			cout<<endl<<"------------------------------------"<<endl;
			cout<<"Enter a 3x4 Aug. Matrix to find its solutions"<<endl;
			cout<<"------------------------------------"<<endl<<endl;
			cin>>a1>>a2>>a3>>a4;
            if (a1==0 && a2==0 && a3==0 && a4==0){
                continue;
            }
			cin>>b1>>b2>>b3>>b4;
			cin>>c1>>c2>>c3>>c4;
            d=det3(a1,a2,a3,b1,b2,b3,c1,c2,c3);
            d1=det3(a4,a2,a3,b4,b2,b3,c4,c2,c3);
            d2=det3(a1,a4,a3,b1,b4,b3,c1,c4,c3);
            d3=det3(a1,a2,a4,b1,b2,b4,c1,c2,c4);
            x=d1/d;
            y=d2/d;
            z=d3/d;
            cout<<endl<<"--------------------------------"<<endl;
            cout<<"  X = "<<x<<" = "<<d1<<"/"<<d<<" | ";
            cout<<"Y = "<<y<<" = "<<d2<<"/"<<d<<" | ";
            cout<<"Z = "<<z<<" = "<<d3<<"/"<<d<<endl;
            cout<<"--------------------------------"<<endl<<endl;
		}else if(ord ==2){
			float a1,a2,a3,b1,b2,b3,d,d1,d2;
            float x,y;
			cout<<endl<<"------------------------------------"<<endl;
			cout<<"Enter a 2x3 Aug. Matrix to find its solutions"<<endl;
			cout<<"------------------------------------"<<endl<<endl;
			cin>>a1>>a2>>a3;
            if (a1==0 && a2==0 && a3==0){
                continue;
            }
			cin>>b1>>b2>>b3;
			d=det2(a1,a2,b1,b2);
            d1=det2(a3,a2,b3,b2);
            d2=det2(a1,a3,b1,b3);
            x=d1/d;
            y=d2/d;
            cout<<endl<<"--------------------------------"<<endl;
            cout<<"  X = "<<x<<" = "<<d1<<"/"<<d<<" | ";
            cout<<"Y = "<<y<<" = "<<d2<<"/"<<d<<endl;
		    cout<<"--------------------------------"<<endl<<endl;
            
		}
	}
    return 0;
}
