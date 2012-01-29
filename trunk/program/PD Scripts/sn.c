//Analysis Type - Regression 
#include <stdio.h>
#include <conio.h>
#include <math.h>
#include <stdlib.h>


double input_hidden_weights[73][6]=
{
 {3.79070482610411e-001, 7.95057816411520e-001, -1.78489172787911e+000, 7.82698959171693e-001, -1.47127612879726e-001, -5.58852058066897e-001 },
 {1.44049553394683e-001, -2.96269466716829e-002, -3.02438978107273e-001, -4.72781122766471e-003, -1.96573240659120e-001, 7.57021074321909e-003 },
 {8.88133608878165e-002, -1.51355878149909e-003, -3.04851623616972e-001, -8.02803585026266e-003, -8.73556149469820e-002, -1.28352833211503e-001 },
 {-8.97389005454939e-001, 3.33583964868050e+000, -2.93694756974498e+000, 3.44936397192198e+000, 4.79685579594719e+000, -3.48011989672469e+000 },
 {2.02222375553719e-001, 1.47857685428769e-001, -4.95432005588564e-001, 1.26725855072098e-001, -4.06606890147958e-001, -2.39587171735925e-003 },
 {-3.91889329954373e+000, 4.90757206866041e+000, 2.45858682603225e+000, 4.88420104354539e+000, -1.29000490400461e+000, -3.92079897612629e+000 },
 {-3.05488345509637e-002, -9.03854702960272e-003, 1.90724763264238e-001, -1.41531032984839e-002, 3.26994830527236e-002, -6.70170886858023e-002 },
 {6.31642145904677e-001, 7.93613830384703e-003, -5.95841543076277e-001, 2.15143872129224e-002, -5.67897064786707e-001, 4.40337135542348e-001 },
 {6.62089739848204e-001, 1.34538274845627e-001, -6.34612727861704e-001, 1.48945086340779e-001, -8.19861183587816e-001, 4.90958161891433e-001 },
 {-1.03984334195793e-001, -4.65094499909618e-002, 3.95458353045909e-001, -7.93147098627419e-002, 2.26786005805824e-001, -1.06645283416523e-001 },
 {9.10472611695705e-001, -1.46510556649670e+000, 6.70688422060339e-001, -1.42408846999044e+000, -4.30112327600258e-001, 2.04418729118665e+000 },
 {-6.01161342886185e+000, 5.72160682519657e+000, 3.41224634742771e-001, 5.67776180312106e+000, -6.56176848883026e+000, -5.06269196666382e+000 },
 {7.88011603570017e-001, 9.03365301341783e-001, -1.67651511159706e+000, 9.53507996568644e-001, -6.80010770511422e-001, 2.30619717657296e-004 },
 {1.85662632024726e-001, 4.14262272441969e-001, -1.05634223866740e+000, 4.14057922435446e-001, -3.63789576403461e-001, -4.51559392658616e-001 },
 {-1.17123744122163e-001, -6.02720928612661e-002, 3.72352634245680e-001, -7.58366800869898e-003, 2.20935080182718e-001, -1.26891179329995e-001 },
 {9.08427314497745e-001, 6.22414810322864e-001, -1.25332023899856e+000, 6.50599510434609e-001, -1.22669895691945e+000, 3.63405558052154e-001 },
 {9.05905739692940e-002, 1.83226778621688e+000, -2.95973512758073e+000, 1.83315837515355e+000, 1.35216032968308e+000, -2.02342710703414e+000 },
 {4.83127138385979e-001, 3.40781914331721e-001, -9.55993392011482e-001, 3.60191740343029e-001, -7.47887905774704e-001, 8.95313552841906e-002 },
 {-1.30802028050337e-001, -1.21181191923448e-001, 2.09191988624221e+000, -1.93496090749906e-001, 1.32016884692046e+000, 1.33889229582698e-001 },
 {3.25154329115673e-002, -2.31835831792528e-002, 4.08038977556320e-002, 1.19171337471914e-003, -1.07726047620713e-001, 4.59972738299576e-002 },
 {-5.31494035471572e-001, 3.25204042790273e-001, 7.11546909741854e-001, 3.09529639849307e-001, 3.96643542339825e-001, -6.30187639736740e-001 },
 {-9.32320708017931e+000, 1.55348809910280e+000, 1.29723155976220e+001, 1.72585856778535e+000, 3.48028217704688e+000, 3.21014829420530e+000 },
 {1.12030679716226e-001, -2.28892966252434e-001, 5.66312458082988e-001, -2.70829288379414e-001, 1.58656354231677e-001, 2.45390839192618e-001 },
 {2.35951806490487e-001, 7.74367225886572e-001, -1.72179084562499e+000, 8.11364979790662e-001, 1.91006862964437e-002, -8.16693102007024e-001 },
 {3.26148372231104e+000, 2.95717979437906e+000, -1.38596184063665e+000, 3.09088027167227e+000, -9.54543341485051e-001, 2.39380468635235e+000 },
 {4.55219033190545e-002, -2.50728112359342e-001, 8.59143999454487e-001, -2.18253477100980e-001, 2.93689186635120e-001, 1.92282625426897e-001 },
 {7.90811011332914e-001, -1.30288421662108e+000, 1.09971037951488e+000, -1.34101685512196e+000, 2.22937352673115e-001, 1.62553999177868e+000 },
 {-4.02753983012046e-001, 1.12012496696214e-001, 2.00899879673112e+000, 8.64653868249108e-002, 1.52834908181183e+000, -2.64435857411299e-001 },
 {-1.18304147389870e+000, 1.01797010169154e+000, 2.48589348501410e+000, 1.04886292018406e+000, 1.46904186330167e+000, -1.46053320447602e+000 },
 {1.05785095074577e-002, -3.23943254203144e-001, 1.32533505069537e+000, -2.86796690630566e-001, 7.15545566900683e-001, 3.89533365158039e-001 },
 {4.41452942089253e-001, 4.02849672282406e-001, -1.06070933561955e+000, 4.18933372865436e-001, -5.72976752126085e-001, 3.36543820505310e-002 },
 {5.42012987328512e-001, 4.75261954019355e-001, -1.22905736168778e+000, 5.23577220009005e-001, -6.88432446872124e-001, -8.26672207248643e-002 },
 {1.69234840559122e+000, -2.90708010034622e+000, 1.03860130115982e+000, -2.91056771478899e+000, -5.37228932762348e-001, 2.79852496198804e+000 },
 {1.72172980002494e-001, -2.92644496348831e-001, 2.92951037639009e-001, -2.85933575160545e-001, 1.12295457461365e-001, 3.93779920734684e-001 },
 {-2.20361154731803e-001, 4.15809688988453e-003, 6.52526107499683e-001, -2.66846239956746e-004, 4.24078848248368e-001, -2.15822557528818e-001 },
 {-1.40626711610351e-002, -1.56206417646381e-001, 3.69384197173499e-001, -1.72433658440682e-001, 2.63339761297933e-001, 5.63759297341541e-002 },
 {-8.38164866722230e-001, 4.71968919044884e-001, 7.73777706269957e-001, 4.36533404362673e-001, 6.56889450825055e-001, -9.93057856298625e-001 },
 {2.09490291488669e-001, 1.79630832750324e-001, -4.61532946078219e-001, 1.66896285321535e-001, -4.88842945619059e-001, 2.19535432825523e-002 },
 {6.86570855258711e-003, -3.07218840901607e-002, 1.02603623296602e-001, 2.57999276380895e-002, -3.72349672500438e-002, 4.48266625678982e-002 },
 {2.35107477974196e-001, -4.70068784400204e-001, 1.80346132399608e+000, -5.18483968032262e-001, 1.07158664270772e+000, 4.01422717861607e-001 },
 {-3.00927551237404e-001, 1.50470312124951e-001, 5.36477524859153e-001, 1.43462885403843e-001, 2.61843453932315e-001, -3.48778826328758e-001 },
 {-2.30607288250444e-001, -3.82513020239847e-002, 1.26038467463682e+000, 3.71352123582784e-002, 7.13491264422696e-001, -1.37320627034461e-001 },
 {5.10880133715189e-001, 1.48976372769329e-001, -8.91113922875752e-001, 1.65358401370361e-001, -6.08155462007450e-001, 1.99098392085895e-001 },
 {5.41339677379990e-002, 7.66165964765338e-002, -9.08823939054381e-002, 6.34104498215152e-002, -2.31479934413867e-001, 1.23295134074078e-002 },
 {-6.05172409641359e-001, 9.97925721401669e-001, 3.36293962953178e+000, 9.56274038188364e-001, 1.80328597693662e+000, -1.29166020252137e+000 },
 {2.04417658561658e+000, -5.08734889726176e+000, -6.61791724585160e-002, -5.19510201864852e+000, 1.00062970357627e+000, 4.01287194600116e+000 },
 {4.07262444960779e+000, 3.41877897324867e+000, 8.50129147548824e+000, 3.29354341319034e+000, 4.74729468073039e+000, -4.58238327550957e-001 },
 {1.07408626974045e-001, -1.19995540469982e-002, -1.28996953278069e-001, 6.49490369060399e-002, -2.12368357937847e-001, -6.93592164044954e-003 },
 {7.27952777881597e-001, 1.69475012461035e-001, -6.31492561342185e-001, 1.60960627848757e-001, -8.31064191113060e-001, 5.15876887652188e-001 },
 {1.16642182694314e+000, -1.83549494933895e+000, 9.44221175081460e-001, -1.87795521027474e+000, -6.47074398386869e-002, 1.97604806741613e+000 },
 {-5.03464404626553e-002, 3.88910299155167e-001, -2.74250239040647e-001, 3.68784711339688e-001, -8.79488157058880e-002, -3.22209186128478e-001 },
 {-1.38398617681311e-001, -1.07552854583366e+001, -4.34560264400198e+000, -1.07603083813057e+001, 8.85994757158824e-001, 6.26720725038386e+000 },
 {1.04200315023582e+000, 1.03067863063632e+000, -1.43554627578104e+000, 1.00836741843557e+000, -1.13612470551505e+000, 3.91764786702874e-001 },
 {-2.18412843095459e-002, 4.88319677078967e-003, 1.95802644825395e-001, 4.52173932834344e-002, -1.07537990926245e-001, -2.53158339375790e-002 },
 {5.78242359472436e-001, 2.36531268774525e-001, -8.39958173830975e-002, 2.89638505743680e-001, -3.32450291804748e-001, 2.92380950442785e-001 },
 {1.81399467786591e-001, 6.06393222795125e-002, -1.14517447798509e-001, 2.19883991524079e-002, -2.37549332712189e-001, 5.30163368509360e-002 },
 {3.72739899347169e-001, 5.94524653678943e-002, -3.74039258141547e-001, 5.30577821138625e-002, -5.34662191708219e-001, 2.55195765203924e-001 },
 {4.96304077217111e-001, 1.30767461181773e-001, -2.60398501750834e-001, 1.25099927894629e-001, -5.74254290405403e-001, 4.02521774319298e-001 },
 {-2.08895467341478e+000, 2.78618152320405e+000, 2.72371085141080e+000, 2.76090113802115e+000, 5.10948661251693e-001, -2.80324744444625e+000 },
 {4.90333488387682e-002, 3.72550409794205e-001, -7.32069244123396e-001, 4.17581307745384e-001, -2.61297273554709e-001, -4.08679155210368e-001 },
 {7.21807603869479e-001, -1.20650091098552e+000, 1.98774825623334e+000, -1.27501507096305e+000, 1.24445430808708e+000, 1.19431137818123e+000 },
 {3.07606448467082e-001, -5.01710589520527e-001, 1.07313133924457e+000, -5.04466519596989e-001, 3.70372126507520e-001, 4.60696145159480e-001 },
 {-1.06973196703121e+000, 7.21095705573230e-001, 1.68686527190264e+000, 7.26849713569515e-001, 1.14546048909183e+000, -1.25102776430231e+000 },
 {2.37029340989130e-001, 3.81170843360028e-002, -3.01886846233541e-001, 1.29175157718479e-002, -3.17726656827504e-001, 9.33584137314215e-002 },
 {1.20977331931692e-003, 3.31344550068272e-001, -6.30323272916091e-001, 3.91756509719661e-001, -1.71714208040467e-001, -4.49585670073549e-001 },
 {1.16646217316840e+000, 1.15640764638078e+000, -7.78738396810006e-001, 1.24445379293774e+000, -1.12979448214147e+000, 1.23835202984498e+000 },
 {5.90932699896672e-001, 6.10777898121978e-001, -1.13854602483033e+000, 6.23738767650747e-001, -7.87315166085241e-001, 3.54361516640160e-002 },
 {1.21335554994439e-001, 1.09749564544331e-001, -1.66649321722706e-002, 9.07432036552295e-002, -1.94136231964527e-001, 2.53137408383320e-002 },
 {3.93518017017511e-001, 5.86334503468729e-002, -5.90626328266038e-001, 7.04603442628208e-002, -5.01789477159710e-001, 1.96089490896761e-001 },
 {8.56166074503731e-001, 2.59933379589455e-001, -6.79185761912802e-001, 2.08497294115055e-001, -9.36690095412989e-001, 6.85101295892327e-001 },
 {2.55727000429210e+000, 1.13662894680796e+000, -1.24604871470359e+000, 1.18517171592482e+000, -2.26545391585533e+000, 2.20074968341875e+000 },
 {5.73368440358224e-001, 1.33996438850430e-001, -3.07746083333905e-001, 1.77388427897300e-001, -6.46746642573015e-001, 4.97067933622748e-001 },
 {1.57016689447927e-001, 1.80473833557681e-001, -6.32830339561544e-001, 1.99664932068274e-001, -3.50751850533836e-001, -1.56003035208233e-001 } 
};

double hidden_bias[73]={ -3.43226921618370e-001, -2.97704878216956e-002, -1.86562382830137e-001, -1.87958778100730e+000, -1.23681249584986e-002, 8.51898258114758e-002, -2.20827692557349e-001, 2.10599010873726e-001, 1.76325852556639e-001, -1.59703408307101e-001, 1.16032516660148e-002, 1.54312699396523e+000, -2.58060726456358e-001, -6.24270476301857e-002, -1.41426881412461e-001, 1.43008755124911e-001, -1.23787943187233e+000, 4.08275845007606e-002, -3.84423633405227e-001, -1.71720291227207e-001, -3.41123394320470e-001, -1.60460670134593e+000, -1.53518394998736e-001, -4.97395903112985e-001, -8.27366202552012e-001, -3.09021704030987e-001, -1.11871070070703e-001, -3.47817055809170e-001, -9.39889796629633e-001, -1.77473756004705e-001, -1.20231779349667e-001, -5.68115125980407e-002, -1.05946689230983e+000, -6.81984550327559e-002, -2.34640270565918e-001, -1.50870171057420e-001, -4.99604174346309e-001, -4.48974851914957e-002, -1.43964242479910e-001, -4.78849220311576e-001, -3.06632484426143e-001, -3.54873809308200e-001, 6.73317245890958e-002, -1.40474522093639e-001, -8.81500473919508e-001, -1.80735770617312e-001, -3.19569862131171e+000, -9.97713144209771e-002, 2.06550551292424e-001, -1.93468902332117e-001, -1.62467511026772e-001, -2.16040892230761e-001, -1.23243866324842e-001, -2.07216668635988e-001, -1.33156365962554e-001, -6.58394538893092e-002, 1.31988212585656e-002, 4.11098159832992e-002, -1.29452458195806e+000, -1.47554801271037e-001, -4.24844611604681e-001, -3.60412106018002e-001, -6.47311397355239e-001, -4.94302875732929e-002, -1.10938604833993e-001, -1.70143245925169e-001, -1.60008097768539e-001, -1.16917628585905e-001, 2.01044034833517e-002, 2.33092554534463e-001, 8.37340555281322e-001, -4.14333042959317e-003, -1.23061572572671e-001 };

double hidden_output_wts[1][73]=
{
 {-3.26384381322020e-001, -2.18373597405104e-001, -2.11334291533091e-001, -8.40804048598042e-001, -2.59487720588604e-001, 1.77546804313824e+000, -3.94447586172352e-002, -5.81008778685220e-001, -5.04178812644190e-001, 7.24713076991342e-002, 3.15847989719179e-001, 2.60519979016814e+000, -5.34172448519166e-001, -4.44162435494632e-001, 9.22408043678446e-002, -6.86097106291763e-001, -6.17364386421457e-001, -4.48935483148109e-001, 8.83230703177114e-001, -1.62094851256677e-002, 1.19337543991350e-001, -1.10303036221440e+000, 2.37634955560044e-001, -2.43643640346730e-001, -1.47666632967893e+000, 2.46173786260961e-001, 4.97933677786957e-001, 8.35569992972681e-001, 8.58002126020919e-001, 6.80402480402965e-001, -2.21411711176314e-001, -5.06214641304269e-001, 3.04480658781351e-001, 1.91141878279009e-001, 1.82984537616136e-001, 2.02777039245497e-001, 8.29099531533024e-002, -2.51778282008425e-001, 1.14729571905887e-001, 6.61651507340485e-001, 1.39240712069009e-002, 4.75626788109749e-001, -4.20709211218584e-001, -4.99312874175172e-002, 9.30540532798608e-001, 5.89631547781349e-001, 8.90728275428203e-001, -2.01865808117124e-001, -5.10467734593593e-001, 1.87133990546546e-001, -2.91716352506523e-001, 1.82549747883012e+000, -5.95077507050387e-001, -3.76286466652723e-002, -8.89692337536283e-001, -4.22805962341416e-001, -3.98322709714159e-001, -4.26126426718184e-001, 4.51683388146813e-001, -3.11665588174004e-001, 8.48462855304925e-001, 2.60159343497210e-001, 5.61825969586064e-001, -3.41406736471823e-001, -3.54729416056760e-001, -1.96286834366967e-001, -4.15789038353562e-001, -2.31776441931079e-001, -4.01490425366324e-001, -4.53580728674640e-001, -1.18552236758954e+000, -4.21117619574688e-001, -3.13223758445026e-001 }
};

double output_bias[1]={ -4.94531558253582e-002 };

double max_input[6]={ 6.43300000000000e-002, 5.64700000000000e-002, 7.94000000000000e-002, 1.69420000000000e-001, 3.30470000000000e+001, 3.14820000000000e-001 };

double min_input[6]={ 1.90000000000000e-003, 4.68000000000000e-003, 5.70000000000000e-003, 1.40300000000000e-002, 8.44100000000000e+000, 6.50000000000000e-004 };

double max_target[1]={ 1.00000000000000e+000 };

double min_target[1]={ 0.00000000000000e+000 };

double input[6];
double hidden[73];
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
  ComputeFeedForwardSignals((double*)input_hidden_weights,input,hidden,hidden_bias,6, 73,0);
  ComputeFeedForwardSignals((double*)hidden_output_wts,hidden,output,output_bias,73, 1,1);
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
        ScaleInputs(input,0,1,6);
    	RunNeuralNet_Regression();
    	UnscaleTargets(output,0,1,1);
    	printf("PredictedState=%lf",output[0]);
        return 0;
     }else{
         printf("Not given enough arguments");
         return -1;
    }
}


