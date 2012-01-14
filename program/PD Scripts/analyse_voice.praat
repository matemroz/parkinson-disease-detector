form Plot a pitch contour
   word inarg "filename"
endform

if (inarg$="")
   echo Usage: praatcon analyse_voice.praat <filename_with_no_ext>
   exit
endif

soundName$ = inarg$
inputFileName$ = soundName$ + ".wav"
outputFileName$ = soundName$ + ".txt"
echo Loading file 'inputFileName$'
Read from file... 'inputFileName$' 
echo 'inputFileName$' is loaded

snd = selected ("Sound")

To Pitch (cc)... 0 60 15 yes 0.03 0.45 0.01 0.35 0.14 600
pit = selected ("Pitch")

# Create Point Process
##################################################################
select snd
plus pit
To PointProcess (cc)

# Jitter measurement
##################################################################
jitter_ddp = Get jitter (ddp)... 0 0 0.0001 0.02 1.3

plus snd

# Shimmer measurement
##################################################################
shimmer_apq3 = Get shimmer (apq3)... 0 0 0.0001 0.02 1.3 1.6
shimmer_apq5 = Get shimmer (apq5)... 0 0 0.0001 0.02 1.3 1.6
shimmer_dda = Get shimmer (dda)... 0 0 0.0001 0.02 1.3 1.6

# Extract harmonicity to noise ratio 
# Preprocessing for minimum and maximum Pitch Range
####################################################
#snd = selected ("Sound")
#select snd
#To Pitch (cc)... 0 60 15 yes 0.03 0.45 0.01 0.35 0.14 600
#pit = selected ("Pitch")
#median = Get quantile... 0 0 0.5 Hertz
#minPitch = median*exp(-10*ln(2)/7)
#timeStep = 0.25/minPitch

snd = selected ("Sound")
select snd
To Harmonicity (cc)... 0.01 75 0.1 1
hnr = Get mean... 0 0

#NHR //TODO

echo Demanded parametres are successfully calculated: jitter (ddp), shimmer (apq3), shimmer (apq5), shimmer (dda), hnr

fileappend 'outputFileName$''tab$''jitter_ddp''tab$''shimmer_apq3''tab$''shimmer_dda''tab$''hnr''newline$'

echo All parametres are written to file 'outputFileName$'