# Phage-MAP Docker Image

Latest Doc Update: 10/16/2021

You can use this `Docker` image to construct your own data processing pipeline.



### Contents

- [Introduction](#intro)
- [Download and Configuration](#download)
- [Tools Running Test](#test)
- [Reset Container](#re)
- [Contributors](#contributors)
- [TIPs](#tips)

### <a name="intro" style="color:black">Introduction</a>

`CentOS 8` running environment for our workflow.
All related bioinformatics tools are configured in directory **/usr/test**.
Bioinformatic Tool Context:

- BLAST 2.11.0+
- ClustalW 2.1
- EMBOSS 6.6.0
- CD-HIT
- Vienna RNA package
- [CRISPRDetect 2.4](http://crispr.otago.ac.nz/CRISPRDetect/CRISPRDetect_help.html)
- [WIsH](https://github.com/soedinglab/wish)
- [PHP](https://github.com/congyulu-bioinfo/PHP)

Other Configure:

- Python 3.9.5 (latest)
- Perl v5.26.3
- Anaconda 4.10.1



### <a name="download" style="color:black">Download and Configuration</a>

1. You should download **docker** on your device first.

   Download Web: https://docs.docker.com/get-docker/
   
   If you use a `Windows` system, please also download `WSL 2 backend`. ([Instruction Web](https://docs.microsoft.com/en-us/windows/wsl/install-manual#step-4---download-the-linux-kernel-update-package))  

2. Pull image from [docker hub](https://hub.docker.com/repository/docker/tp29/phage-map) or run `DockerFile` to build your own image:
   
   (1) Use `DockerFile` on GitHub:
   
   **Please make sure you have clone whole repositories locally!!!**
   
   If you haven't clone this repositories, please run following code:
   ```shell
   git clone https://github.com/tj-Acmen/Tongji_Software.git
   cd Tongji_Software/data-processing
   ```
   Then, you could run following code to build your own `Phage-MAP` image: 

   ```shell
   docker build -f DockerFile -t tp29/phage-map:latest .
   ```
   (2) Docker Hub:

   ```dockerfile
   docker pull docker.io/tp29/phage-map:latest
   # or
   docker pull tp29/phage-map
   ```

   If you got a **deamon error**, please make sure you have started `docker` service.
   
   If you still got a **deamon error**, please close other process on your PC and retry the above command.

3. Create a container with interaction interface.

   ```dockerfile
   docker run --name=[container name] -it tp29/phage-map
   ```

4. Go to the working directory.

   ```shell
   cd /usr/test
   ```


5. Test your pre-required softwares.

   ```shell
   # Bioinfomatics Tools
   blastn -help
   clustalw -help
   cd-hit-est -help
   water -help
   seqret -help
   RNAfold -help
   
   # Other 
   python3 --version
   pip3 --version
   perl --version
   conda --version
   ```

6. Exit the container.

   ```shell
   exit
   ```

7. Enter the existed container interface.

   ```dockerfile
   # These operations should be done between Step 3 and Step 4
   docker start [container name/ID]
   docker attach [container name/ID]
   ```

8. Create your own file.

   I highly recommend you create your file on following path: 

   ```shell
   cd /usr/test/workpath
   ```




### <a name="test" style="color:black">Tools Running Test</a>

#### CRISPRDetect for Spacers

##### Running Example

```shell
# Test with default data in GenBank format
# Test CRISPRDetect on absolute path
cd /usr/test/CRISPRDetect_2.4
perl CRISPRDetect.pl -g NZ_CP006019.gbk -o NZ_CP006019_CRISPRDetect.txt
# Test CRISPERDetect with command alias
cd /usr/test/CRISPRDetect_2.4
detect -g NZ_CP006019.gbk -o NZ_CP006019_CRISPRDetect.txt
# You should get an output of running log on your terminal
```

##### Brief Helping Doc of CRISPRDetect

Basic Usage: 

```shell
# You can use the "detect" command to run CRISPRDetect convienently. 
# Basic command format:
detect -g/f [input file] -o [output file] [options]
# -g GenBank format    
# -f fasta format
```

Basic Options:

```shell
# -h 
# helping document (README)

# -word_length	 
# word length to find the putative CRISPRs, >=6, default 11

# -minimum_word_repeatation 	
# By default CRISPRDetect uses 2 repeating identical words to find putative CRISPRs 

# -minimum_repeat_length		
# minimum length of repeats, default 23 

# -array_quality_score_cutoff	
# CRISPRs with score less than this value will be excluded, default 4 
```

You can run personal specialized CRISPRDetect by setting optional parameter.

More INFO from [CRISPRDetect Help Web](http://crispr.otago.ac.nz/CRISPRDetect/CRISPRDetect_help.html).



#### BLAST Analysis

##### Running Example

1. `CRISPRDetect ` result :

   ```shell
   cd /usr/test/workpath
   mkdir testOut
   detect -f ../ExampleFiles/detectIn.fasta -o testOut/detectOut.txt
   
   # format transformation
   python3 ../pyIOscript/detectOut2blastIn.py testOut/detectOut.txt testOut/spacers_blastIn.txt
   ```

2. `makeblastdb` command: 

   ```shell
   makeblastdb -in ../ExampleFiles/phg.fasta -input_type fasta -dbtype nucl -parse_seqids -out testOut/nt.db
   ```

3. `blastn` command: 

   ```shell
   blastn -query testOut/spacers_blastIn.txt -db testOut/nt.db -task blastn -evalue 1 -outfmt 6 -out testOut/blastOut.tab
   ```

4. Bitscore extraction: 

   ```shell
   python3 ../pyIOscript/blastRe2bitTab.py testOut/blastOut.tab testOut/bitScore.tab
   ```

5. Running all above steps with **this** command: 

   ```shell
   cd /usr/test/workpathmkdir testOut
   python3 ../pyIOscript/generate_bitScore.py
   # Parameters Help
   python3 ../pyIOscript/generate_bitScore.py -h
   ```

   




#### PHP Analysis

##### Running Example

1. Set up predicting model: 

   ```shell
   cd /usr/test/PHPpython3 countKmer.py --fastaFileDir  ./exampleHostGenome --kmerFileDir ./exampleOutput --kmerName HostKmer  --coreNum -1# python3 countKmer.py -f ./exampleHostGenome -d ./exampleOutput -n HostKmer -c -1
   ```

2. Use model to predict `PHP` score matrix: 

   ```shell
   python3 PHP.py --virusFastaFileDir ./exampleVirusGenome  --outFileDir ./exampleOutput  --bacteriaKmerDir ./exampleOutput  --bacteriaKmerName HostKmer# python3 PHP.py -v ./exampleVirusGenome  -o ./exampleOutput  -d ./exampleOutput  -n HostKmer
   ```

   

##### Brief Helping Doc of PHP

More INFO from [PHP GitHub](https://github.com/congyulu-bioinfo/PHP).





#### WIsH Analysis

##### Running Example

1. Set up predicting model: 

   ```shell
   cd /usr/test/WIsH/mkdir modelDir./WIsH -c build -g exampleBacDir -m modelDir
   ```

2. Use model to predict `WIsH` score matrix:

   ```shell
   mkdir outputResultDir./WIsH -c predict -g examplePhgDir -m modelDir -r outputResultDir -b 1
   ```

   

##### Brief Helping Doc of WIsH

More INFO from [WIsH GitHub](https://github.com/soedinglab/wish).



#### Final Score Analysis

##### Running Example

1. Generate scaled matrix:

   ```shell
   cd /usr/test/workpath
   # Default using test files
   python3 ../pyIOscript/generate_matrix.py
   # Parameters Help
   python3 ../pyIOscript/generate_matrix.py -h 
   ```

2. Topsis analysis for final score table:

   ```shell
   # Default using test files
   python3 ../pyIOscript/generate_finalScore.py 
   # Parameters Help
   python3 ../pyIOscript/generate_finalScore.py -h
   ```

   

### <a name="re" style="color:black">Reset Container</a>

```shell
rm -rf /usr/test/workpath/testOut
rm -rf /usr/test/PHP/exampleOutput
rm -rf /usr/test/WIsH/outputResultDir
```



### <a name="tips" style="color:black">TIPS</a>

- About Running Test: 

  The configuration has been tested successfully on **Mac OS X Big Sur 11.6**.

  Configuration on **Windows** need installation of Linux kernel as prerequisite.

  **For iGEMers:**

  **Welcome to provide your installing procedures to help me improve this doc.**

- If you want to learn more basic knowledge of `Docker`, please click this <a href="https://www.cnblogs.com/koktlzz/p/14105026.html">**link**</a> or go to <a href="https://docs.docker.com/get-started/overview/">**Official Docker Documentation**</a>. 



### <a name="contributors" style="color:black">Contributors</a>

Sincerely thanks to **Yanping Zhao**, **Songyang Li**, **Letian Li** for their contribution of this `Phage-MAP` docker image construction.

