//Analysis Type - Regression 
#include <stdio.h>
#include <conio.h>
#include <math.h>
#include <stdlib.h>


double input_hidden_weights[12][8]=
{
 {1.12866631641332e-001, 5.71637105239250e-001, 9.01961560361806e-001, 5.78788749691118e-001, -2.16595311827735e+000, -1.26272347210668e-002, 4.03233327976415e+000, -1.42606286630105e+000 },
 {1.15925304207822e+000, 6.83012774442187e-001, 2.34425575344112e+000, 7.31625868920993e-001, -1.07903670626660e+000, -5.47480768017711e-001, 4.37555118474281e+000, -1.58380369042130e+000 },
 {-2.47561910197088e+000, 2.54471944171124e+000, -1.25023200253940e+000, 2.49781468261744e+000, -1.95256615446182e+000, 1.36744755347377e+000, 6.44875937643740e+000, -1.14792089602253e+000 },
 {2.48090975795972e+000, 3.66246541314310e+000, 6.88081607106930e+000, 3.70847504009020e+000, -3.10222291583033e+000, -3.44171518960970e+000, 1.94805458047005e+001, -3.22105923396598e+000 },
 {-3.78501273167764e+000, 4.21876314834255e+000, -4.60335505958101e+000, 4.24442383075030e+000, -2.07380236304405e+000, 1.08188374675850e+000, 1.20081935473279e+001, -8.41462494187503e-001 },
 {3.42008108429858e+000, 5.12278286955869e-001, 2.89331017457239e+000, 5.40151571878803e-001, -2.46426230511850e-001, -2.49823499243856e-001, 5.73028884419269e+000, 3.01446338578374e-001 },
 {1.27734308162132e+000, 9.46265108994108e-001, 2.11002300463325e+000, 9.78434065340875e-001, -1.17798358476954e+000, -5.69422150676304e-003, 4.45108473966887e+000, -1.92790391870778e+000 },
 {3.61087266167238e+000, -1.04629475091669e+000, 2.25615078670901e+000, -1.05220589491043e+000, -9.38670334138202e-002, 4.08099224491240e-001, 5.52910941328395e-001, -4.63449607110925e+000 },
 {-2.52781629157657e-001, 1.10110905877338e+000, 3.83782771140448e-001, 1.13107461588190e+000, -1.49191668833497e+000, 4.53822141526274e-001, 4.19378148479298e+000, -1.57918799418152e+000 },
 {2.28399500587933e+000, -3.46650863912247e-001, 3.66321972231272e+000, -2.87288768736187e-001, -7.72876162499096e+000, -1.41020089584442e+000, 1.27008896074336e+001, 2.55186279135132e+000 },
 {-3.79644595440000e+000, 5.42586229942550e+000, -1.97105577074502e+000, 5.39942679934492e+000, -4.09722647275755e+000, 2.31973282918754e+000, 5.70247274918948e+000, -5.65090757714995e+000 },
 {-4.17305172603105e+000, 6.35165713746619e-001, -7.42706840477941e-001, 6.33200255319056e-001, -2.59676288373930e+000, 1.59968114838644e+000, 8.21479173456428e+000, 1.07698462721718e+000 } 
};

double hidden_bias[12]={ -3.10215026204687e+000, -1.76462720439535e+000, -1.33681117128043e-001, -2.72149615724591e+000, -6.26426917940004e-002, -3.00580039945144e-001, -1.01196171747278e+000, 3.23177585019813e+000, -1.49749906397878e+000, -9.47879618749952e+000, -2.10899332348086e+000, -9.00729487834090e-001 };

double hidden_output_wts[1][12]=
{
 {1.77334980190078e+000, -9.91499138658233e-002, 1.08421098000991e+000, 1.13751511284420e+000, -5.62071474806271e+000, 5.63571288496844e+000, -3.83232041577727e-001, 1.55488775753633e+000, 1.69688153775876e+000, 2.25091094918132e+000, -3.08860213346017e+000, 4.99063859937043e+000 }
};

double output_bias[1]={ -8.67013328538747e+000 };

double max_input[8]={ 6.43300000000000e-002, 5.64700000000000e-002, 7.94000000000000e-002, 1.69420000000000e-001, 3.30470000000000e+001, 3.14820000000000e-001, 8.50000000000000e+001, 1.00000000000000e+000 };

double min_input[8]={ 2.04000000000000e-003, 4.68000000000000e-003, 5.70000000000000e-003, 1.40300000000000e-002, 8.44100000000000e+000, 6.50000000000000e-004, 4.60000000000000e+001, 0.00000000000000e+000 };

double max_target[1]={ 1.00000000000000e+000 };

double min_target[1]={ 0.00000000000000e+000 };

double input[8];
double hidden[12];
double output[1];

void ScaleInputs(double* input, double minimum, double maximum, int size)
{
 double delta;
 long i;
 for(i=0; i<size; i++)
 {
	delta = (maximum-minimum)/(max_input[i]-min_input[i]);
	input[i] = minimum - delta*min_input[i]+ delta*input[i];
 }
}

void UnscaleTargets(double* output, double minimum, double maximum, int size)
{
  double delta;
  long i;
  for(i=0; i<size; i++)
  {
    delta = (maximum-minimum)/(max_target[i]-min_target[i]);
    output[i] = (output[i] - minimum + delta*min_target[i])/delta;
   }
}

double logistic(double x)
{
  if(x > 100.0) x = 1.0;
  else if (x < -100.0) x = 0.0;
  else x = 1.0/(1.0+exp(-x));
  return x;
}

void ComputeFeedForwardSignals(double* MAT_INOUT,double* V_IN,double* V_OUT, double* V_BIAS,int size1,int size2,int layer)
{
  int row,col;
  for(row=0;row < size2; row++) 
    {
      V_OUT[row]=0.0;
      for(col=0;col<size1;col++)V_OUT[row]+=(*(MAT_INOUT+(row*size1)+col)*V_IN[col]);
      V_OUT[row]+=V_BIAS[row];
      if(layer==0) V_OUT[row] = exp(V_OUT[row]);
      if(layer==1) V_OUT[row] = logistic(V_OUT[row]);
   }
}

void RunNeuralNet_Regression () 
{
  ComputeFeedForwardSignals((double*)input_hidden_weights,input,hidden,hidden_bias,8, 12,0);
  ComputeFeedForwardSignals((double*)hidden_output_wts,hidden,output,output_bias,12, 1,1);
}

int main()
{
  int i=0;
  int keyin=1;
  while(1)
  {
	printf("\nEnter values for Continuous inputs\n");
	printf("Cont. Input-0(Jitter:DDP): ");
	scanf("%lg",&input[0]);
	printf("Cont. Input-1(Shimmer:APQ3): ");
	scanf("%lg",&input[1]);
	printf("Cont. Input-2(Shimmer:APQ5): ");
	scanf("%lg",&input[2]);
	printf("Cont. Input-3(Shimmer:DDA): ");
	scanf("%lg",&input[3]);
	printf("Cont. Input-4(HNR): ");
	scanf("%lg",&input[4]);
	printf("Cont. Input-5(NHR): ");
	scanf("%lg",&input[5]);
	printf("Cont. Input-6(AGE): ");
	scanf("%lg",&input[6]);
	printf("Cont. Input-7(SEX): ");
	scanf("%lg",&input[7]);
    ScaleInputs(input,0,1,8);
	RunNeuralNet_Regression();
	UnscaleTargets(output,0,1,1);
	printf("\nPredicted Output of status = %.14e",output[0]);
	printf("\n\nPress any key to make another prediction or enter 0 to quit the program.\n");
	keyin=getch();
	if(keyin==48)break;
  }
	return 0;
}

