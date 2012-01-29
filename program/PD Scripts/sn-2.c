//Analysis Type - Regression 
#include <stdio.h>
#include <conio.h>
#include <math.h>
#include <stdlib.h>


double input_hidden_weights[11][8]=
{
 {1.00495313778675e+001, -5.21697788584947e+000, -9.06704797895286e-001, -5.25894384735827e+000, 1.76725085819773e-001, -2.15840752898795e+000, 4.69016516693127e+000, 5.03322282383438e+000 },
 {-1.63179867661726e+001, 4.97462580407903e+000, -5.85372017949540e+000, 5.03376764108475e+000, 3.19469174427672e+000, 5.20078443998171e+000, -8.14168671736377e+000, 2.10741471644949e+000 },
 {-4.90874534158033e+000, 1.19580610368148e+000, -1.29724996975937e+000, 1.19474436214471e+000, 3.27793414307549e-001, 2.33481925376874e+000, -2.02575650811336e+000, -2.22876539450479e-001 },
 {1.02019703358912e+001, 6.47772878598955e+000, 2.80526632170518e+000, 6.42660986218033e+000, -6.41844210098276e+000, -1.07258809285034e+001, 1.88400151563736e+001, -5.62408081361665e+000 },
 {-1.62356683387383e+001, 5.03388500174082e+000, -5.94823228203837e+000, 5.06622343088407e+000, -1.60718279892197e+001, -2.26669527031619e-002, 1.25380537906164e+001, -9.39837279700559e-001 },
 {-2.70406499833304e+000, -4.77453842704904e-001, -1.40491203051321e+000, -5.02357397657573e-001, 4.64487739988394e+000, 4.45049466805304e-001, -4.03871003834494e+000, 2.88979653428862e+000 },
 {5.72219293313904e+000, -1.48185177251542e+000, 8.84879660133460e-001, -1.53415914930164e+000, 1.68008505984100e+000, -1.93935029038752e+000, 3.59735129079427e+000, 4.71638215921799e+000 },
 {-3.10516264267175e+000, 8.88526469349138e-001, -1.14008825107286e+000, 8.76259986662857e-001, 1.64834183678345e+000, 2.36083881697591e+000, 1.38935621265516e-001, 3.04840769524752e+000 },
 {3.89204024719701e+000, 1.65184407069948e+000, 2.62041575564772e+000, 1.67436782685270e+000, -4.27839421712836e+000, -7.62262694055132e-001, 5.48656647628153e+000, -3.83943817372625e+000 },
 {2.92487406611711e+000, -3.99488495233671e+000, -8.87853243756020e-001, -4.03135608500007e+000, 4.98298438235754e-001, -3.67972329315828e+000, -5.64732264505172e+000, 9.65159730794604e-001 },
 {2.56202611011404e+000, -4.95273359519088e-001, 6.33890462854989e-001, -5.10404704670941e-001, -2.15278267419619e+000, -7.50093748413438e-001, 3.88200067204234e+000, -2.11836125984037e+000 } 
};

double hidden_bias[11]={ 1.51503327553542e+000, -7.96163238649975e-001, 1.33399079214710e-001, -1.00399811062271e+001, 4.53974164352663e+000, 6.43288754435461e+000, 3.13015745657711e+000, 4.21854559159516e+000, -5.68865247976158e+000, -3.98754721752817e+000, -3.38036938579542e+000 };

double hidden_output_wts[1][11]=
{
 {1.78311809866325e+000, -1.45444690167452e+001, -5.57131812406205e-001, 1.50712849358770e+001, -1.80443778738844e+001, -2.14220420036087e+000, -1.21565424744946e+000, 5.92177218217356e+000, 4.68592700036589e+000, 4.55862164726557e+000, -1.49148508215233e+000 }
};

double output_bias[1]={ 2.46934257721525e+000 };

double max_input[8]={ 6.43300000000000e-002, 5.64700000000000e-002, 7.94000000000000e-002, 1.69420000000000e-001, 3.30470000000000e+001, 3.14820000000000e-001, 8.50000000000000e+001, 1.00000000000000e+000 };

double min_input[8]={ 1.90000000000000e-003, 4.68000000000000e-003, 5.70000000000000e-003, 1.40300000000000e-002, 8.44100000000000e+000, 6.50000000000000e-004, 2.20000000000000e+001, 0.00000000000000e+000 };

double max_target[1]={ 1.00000000000000e+000 };

double min_target[1]={ 0.00000000000000e+000 };

double input[8];
double hidden[11];
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
      if(layer==0) V_OUT[row] = tanh(V_OUT[row]);
      if(layer==1) V_OUT[row] = logistic(V_OUT[row]);
   }
}

void RunNeuralNet_Regression () 
{
  ComputeFeedForwardSignals((double*)input_hidden_weights,input,hidden,hidden_bias,8, 11,0);
  ComputeFeedForwardSignals((double*)hidden_output_wts,hidden,output,output_bias,11, 1,1);
}

int main(int argc, char *argv[])
{
    if(argc == 7){
        input[0] = atof(argv[1]);
    	input[1] = atof(argv[2]);
    	input[2] = atof(argv[3]);
    	input[3] = atof(argv[4]);
    	input[4] = atof(argv[5]);
    	input[5] = atof(argv[6]);
        ScaleInputs(input,0,1,7);
    	RunNeuralNet_Regression();
    	UnscaleTargets(output,0,1,1);
    	printf("PredictedState=%lf",output[0]);
        return 0;
     }else{
         printf("Not given enough arguments");
         return -1;
    }
}

