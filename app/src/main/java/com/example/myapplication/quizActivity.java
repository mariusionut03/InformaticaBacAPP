package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Random;

public class quizActivity extends AppCompatActivity {




    public RelativeLayout layoutId;
    public TextView textView2;
    public TextView answer1Button, answer2Button, answer3Button, answer4Button, answer5Button;
    public String[] intrebariArray = new String[101];
    public String[] raspuns1Array = new String[101];
    public String[] raspuns2Array = new String[101];
    public String[] raspuns3Array = new String[101];
    public String[] raspuns4Array = new String[101];
    public Integer[] raspunsuriArray = new Integer[101];
    public Button exitButton;
    public int numarVerificareRaspuns = 0;
    public int nrAux = 0;
    public int numarTest = 0;
    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String THEME = "switchTheme";
    private boolean theme;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        layoutId = findViewById(R.id.layoutId);
        textView2 = findViewById(R.id.textView2);
        answer1Button = findViewById(R.id.answer1Button);
        answer2Button = findViewById(R.id.answer2Button);
        answer3Button = findViewById(R.id.answer3Button);
        answer4Button = findViewById(R.id.answer4Button);
        answer5Button = findViewById(R.id.answer5Button);
        exitButton = findViewById(R.id.buttonExit);
        exitButton.setOnClickListener(v -> goBackToMain());
        loadIntrebari();
        loadDataLearn();
        setThemeFunction();
        startGame();

        answer1Button.setOnClickListener(v -> {
            answer1Button.setBackgroundColor(Color.parseColor("#990000"));
            answer2Button.setBackgroundColor(Color.parseColor("#990000"));
            answer3Button.setBackgroundColor(Color.parseColor("#990000"));
            answer4Button.setBackgroundColor(Color.parseColor("#990000"));
            if(numarVerificareRaspuns == 1)
            {
                answer1Button.setBackgroundColor(Color.parseColor("#267326"));
            }
            else if (numarVerificareRaspuns == 2)
            {
                answer2Button.setBackgroundColor(Color.parseColor("#267326"));
            }
            else if (numarVerificareRaspuns == 3)
            {
                answer3Button.setBackgroundColor(Color.parseColor("#267326"));
            }
            else
            {
                answer4Button.setBackgroundColor(Color.parseColor("#267326"));
            }
            answer5Button.setVisibility(View.VISIBLE);
        });

        answer2Button.setOnClickListener(v -> {
            answer1Button.setBackgroundColor(Color.parseColor("#990000"));
            answer2Button.setBackgroundColor(Color.parseColor("#990000"));
            answer3Button.setBackgroundColor(Color.parseColor("#990000"));
            answer4Button.setBackgroundColor(Color.parseColor("#990000"));
            if(numarVerificareRaspuns == 1)
            {
                answer1Button.setBackgroundColor(Color.parseColor("#267326"));
            }
            else if (numarVerificareRaspuns == 2)
            {
                answer2Button.setBackgroundColor(Color.parseColor("#267326"));
            }
            else if (numarVerificareRaspuns == 3)
            {
                answer3Button.setBackgroundColor(Color.parseColor("#267326"));
            }
            else
            {
                answer4Button.setBackgroundColor(Color.parseColor("#267326"));
            }
            answer5Button.setVisibility(View.VISIBLE);
        });

        answer3Button.setOnClickListener(v -> {
            answer1Button.setBackgroundColor(Color.parseColor("#990000"));
            answer2Button.setBackgroundColor(Color.parseColor("#990000"));
            answer3Button.setBackgroundColor(Color.parseColor("#990000"));
            answer4Button.setBackgroundColor(Color.parseColor("#990000"));
            if(numarVerificareRaspuns == 1)
            {
                answer1Button.setBackgroundColor(Color.parseColor("#267326"));
            }
            else if (numarVerificareRaspuns == 2)
            {
                answer2Button.setBackgroundColor(Color.parseColor("#267326"));
            }
            else if (numarVerificareRaspuns == 3)
            {
                answer3Button.setBackgroundColor(Color.parseColor("#267326"));
            }
            else
            {
                answer4Button.setBackgroundColor(Color.parseColor("#267326"));
            }
            answer5Button.setVisibility(View.VISIBLE);
        });

        answer4Button.setOnClickListener(v -> {
            answer1Button.setBackgroundColor(Color.parseColor("#990000"));
            answer2Button.setBackgroundColor(Color.parseColor("#990000"));
            answer3Button.setBackgroundColor(Color.parseColor("#990000"));
            answer4Button.setBackgroundColor(Color.parseColor("#990000"));
            if(numarVerificareRaspuns == 1)
            {
                answer1Button.setBackgroundColor(Color.parseColor("#267326"));
            }
            else if (numarVerificareRaspuns == 2)
            {
                answer2Button.setBackgroundColor(Color.parseColor("#267326"));
            }
            else if (numarVerificareRaspuns == 3)
            {
                answer3Button.setBackgroundColor(Color.parseColor("#267326"));
            }
            else
            {
                answer4Button.setBackgroundColor(Color.parseColor("#267326"));
            }
            answer5Button.setVisibility(View.VISIBLE);
        });

        answer5Button.setOnClickListener(v -> {
            if(theme == false)
            {
                answer1Button.setBackgroundResource(R.drawable.style_bg_light_ripple);
                answer2Button.setBackgroundResource(R.drawable.style_bg_light_ripple);
                answer3Button.setBackgroundResource(R.drawable.style_bg_light_ripple);
                answer4Button.setBackgroundResource(R.drawable.style_bg_light_ripple);
            } else {
                answer1Button.setBackgroundResource(R.drawable.style_bg_dark_ripple);
                answer2Button.setBackgroundResource(R.drawable.style_bg_dark_ripple);
                answer3Button.setBackgroundResource(R.drawable.style_bg_dark_ripple);
                answer4Button.setBackgroundResource(R.drawable.style_bg_dark_ripple);
            }
            numarVerificareRaspuns++;
            startGame();
        });
    }




    public void loadDataLearn() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        theme = sharedPreferences.getBoolean(THEME, false);
    }
    public void setThemeFunction() {
        if (theme == false) {
            layoutId.setBackgroundColor(Color.parseColor("#FFFFFF"));
        } else {
            layoutId.setBackgroundColor(Color.parseColor("#000c2e"));
            textView2.setTextColor(Color.parseColor("#FFFFFF"));
            answer1Button.setBackgroundResource(R.drawable.style_bg_dark_ripple);
            answer2Button.setBackgroundResource(R.drawable.style_bg_dark_ripple);
            answer3Button.setBackgroundResource(R.drawable.style_bg_dark_ripple);
            answer4Button.setBackgroundResource(R.drawable.style_bg_dark_ripple);
            answer5Button.setBackgroundResource(R.drawable.style_bg_dark_ripple);
            answer1Button.setTextColor(Color.parseColor("#FFFFFF"));
            answer2Button.setTextColor(Color.parseColor("#FFFFFF"));
            answer3Button.setTextColor(Color.parseColor("#FFFFFF"));
            answer4Button.setTextColor(Color.parseColor("#FFFFFF"));
            answer5Button.setTextColor(Color.parseColor("#FFFFFF"));
        }
    }

    public void loadIntrebari()
    {
        intrebariArray[1] = "Care dintre urmatoarele expresii are valoarea 1 daca si numai daca numarul x apartine intervalului (5, 8]?";
        raspuns1Array[1] = "a. (x<8) && (x>=5)";
        raspuns2Array[1] = "b. (x<=8) || (x>5)";
        raspuns3Array[1] = "c. (x>8) || (x<=5)";
        raspuns4Array[1] = "d. (x<=8) && (x>5)";
        raspunsuriArray[1] = 4;

        intrebariArray[2] = "Valoarea expresiei C/C++: 32 % 6 este:";
        raspuns1Array[2] = "a. 0";
        raspuns2Array[2] = "b. 2";
        raspuns3Array[2] = "c. 3";
        raspuns4Array[2] = "d. 5";
        raspunsuriArray[2] = 2;

        intrebariArray[3] = "Valoarea expresiei C/C++: 12*2+2 este:";
        raspuns1Array[3] = "a. 48";
        raspuns2Array[3] = "b. 26";
        raspuns3Array[3] = "c. 24";
        raspuns4Array[3] = "d. 28";
        raspunsuriArray[3] = 2;

        intrebariArray[4] = "Valoarea expresiei C/C++: 17%6+4%4 este:";
        raspuns1Array[4] = "a. 5";
        raspuns2Array[4] = "b. 0";
        raspuns3Array[4] = "c. 3";
        raspuns4Array[4] = "d. 2";
        raspunsuriArray[4] = 1;

        intrebariArray[5] = "Valoarea expresiei C/C++: 23*6-23*4+16 este:";
        raspuns1Array[5] = "a. 62";
        raspuns2Array[5] = "b. 60";
        raspuns3Array[5] = "c. 67";
        raspuns4Array[5] = "d. 63";
        raspunsuriArray[5] = 1;

        intrebariArray[6] = "Valoarea expresiei C/C++: 62/10*3/17 este:";
        raspuns1Array[6] = "a. 5";
        raspuns2Array[6] = "b. 7";
        raspuns3Array[6] = "c. 1";
        raspuns4Array[6] = "d. 3";
        raspunsuriArray[6] = 3;

        intrebariArray[7] = "Numărul de noduri ale unui arbore cu 4 muchii este:";
        raspuns1Array[7] = "a. 3";
        raspuns2Array[7] = "b. 5";
        raspuns3Array[7] = "c. 4";
        raspuns4Array[7] = "d. 2";
        raspunsuriArray[7] = 2;

        intrebariArray[8] = "Numarul maxim de muchii pe care il poate avea un graf neorientat cu 4 noduri este:";
        raspuns1Array[8] = "a. 5";
        raspuns2Array[8] = "b. 4";
        raspuns3Array[8] = "c. 7";
        raspuns4Array[8] = "d. 6";
        raspunsuriArray[8] = 4;

        intrebariArray[9] = "Utilizand metoda backtracking, se genereaza toate numerele pare de 3 cifre din multimea {4, 5, 6, 8}. Primele 6 solutii sunt: 444, 446, 448, 454, 456, 458. Care este cea de-a 8-a solutie?";
        raspuns1Array[9] = "a. 464";
        raspuns2Array[9] = "b. 456";
        raspuns3Array[9] = "c. 468";
        raspuns4Array[9] = "d. 466";
        raspunsuriArray[9] = 4;

        intrebariArray[10] = "Utilizând metoda backtracking, se generează toate băuturile obținute amestecând sucurile a cel puțin două fructe distincte din mulţimea {afine, caise, lămâi, mere, pere}. Primele cinci soluţii obţinute sunt, în această ordine: (afine, caise), (afine, caise, lămâi), (afine, caise, lămâi, mere), (afine, caise, lămâi, mere, pere) şi (afine, caise, lămâi, pere). A șasea soluţie este:";
        raspuns1Array[10] = "a. (afine, lămâi, mere, pere)";
        raspuns2Array[10] = "b. (afine, caise, mere, pere)";
        raspuns3Array[10] = "c. (afine, caise, mere)";
        raspuns4Array[10] = "d. (afine, mere, pere)";
        raspunsuriArray[10] = 3;

        intrebariArray[11] = "Variabilele x și y sunt întregi. Indicați expresia C/C++ echivalentă cu (x<3) && (y>=5).";
        raspuns1Array[11] = "a. !((x<3) || (y>=5))";
        raspuns2Array[11] = "b. !(x>=3) && (y<5)";
        raspuns3Array[11] = "c. !((x>=3) && (y<5))";
        raspuns4Array[11] = "d. !(!(x<3) || !(y>=5))";
        raspunsuriArray[11] = 4;

        intrebariArray[12] = "Indicaţi expresia C/C++ care are valoarea 1 dacă şi numai dacă numărul natural memorat în variabila întreagă x are exact trei cifre.";
        raspuns1Array[12] = "a. x/1000==0 || x/100!=0";
        raspuns2Array[12] = "b. x%1000==0 && x%100!=0";
        raspuns3Array[12] = "c. x/1000==0 && x/100!=0";
        raspuns4Array[12] = "d. x%1000==0 || x%100!=0";
        raspunsuriArray[12] = 3;

        intrebariArray[13] = "Variabila x este de tip întreg. Numărul de valori întregi distincte ale lui x pentru care expresia C/C++: x/2017 are valoarea 0 este:";
        raspuns1Array[13] = "a. 2018";
        raspuns2Array[13] = "b. 2016";
        raspuns3Array[13] = "c. 2*2016+1";
        raspuns4Array[13] = "d. 2*2017+1";
        raspunsuriArray[13] = 3;

        intrebariArray[14] = "Avem structura urmatoare ce reprezinta coordonatele unui punct. Cum schimbam corect valoarea punctului de abscisa x in 2?" + "\n" + "struct punct {" + "\n" + "int x, y;" + "\n" + "} v;" ;
        raspuns1Array[14] = "a. x.v = 2";
        raspuns2Array[14] = "b. x = 2";
        raspuns3Array[14] = "c. v.x = 2";
        raspuns4Array[14] = "d. v(x) = 2";
        raspunsuriArray[14] = 3;

        intrebariArray[15] = "Utilizând metoda backtracking se generează, în ordine crescătoare, toate numerele naturale pare cu trei cifre, cu proprietatea că nu există două cifre egale alăturate și suma cifrelor este 10. Primele cinci numere generate sunt, în această ordine: 136, 154, 172, 190, 208. Al şaselea număr generat este:";
        raspuns1Array[15] = "a. 217";
        raspuns2Array[15] = "b. 226";
        raspuns3Array[15] = "c. 262";
        raspuns4Array[15] = "d. 280";
        raspunsuriArray[15] = 3;

        intrebariArray[16] = "Expresia C/C++: 3+7/4+3 are valoarea:";
        raspuns1Array[16] = "a. 5.5";
        raspuns2Array[16] = "b. 7.75";
        raspuns3Array[16] = "c. 7";
        raspuns4Array[16] = "d. 1";
        raspunsuriArray[16] = 3;

        intrebariArray[17] = "Utilizând metoda backtracking se generează, în ordine strict crescătoare, toate numerele de trei cifre din mulţimea {1, 2, 5, 7, 8}, numere cu proprietatea că au cel mult două cifre impare. Primele şapte numere generate sunt, în această ordine: 112, 118, 121, 122, 125, 127, 128. Al optulea număr generat este:";
        raspuns1Array[17] = "a. 157";
        raspuns2Array[17] = "b. 151";
        raspuns3Array[17] = "c. 152";
        raspuns4Array[17] = "d. 158";
        raspunsuriArray[17] = 3;

        intrebariArray[18] = "Se consideră un graf neorientat cu 7 noduri şi 21 de muchii. Indicaţi numărul minim de muchii care pot fi eliminate, astfel încât graful parţial obţinut să aibă două componente conexe, cu cel puţin două noduri fiecare.";
        raspuns1Array[18] = "a. 6";
        raspuns2Array[18] = "b. 8";
        raspuns3Array[18] = "c. 12";
        raspuns4Array[18] = "d. 10";
        raspunsuriArray[18] = 4;

        intrebariArray[19] = "Utilizând metoda backtracking se generează toate modalităţile de a scrie numărul 6 ca sumă de numere naturale impare. Termenii fiecărei sume sunt în ordine crescătoare. Cele patru soluţii sunt obţinute în această ordine: 1+1+1+1+1+1; 1+1+1+3; 1+5; 3+3. Aplicând acelaşi algoritm, numărul soluţiilor obţinute pentru scrierea lui 8 este:";
        raspuns1Array[19] = "a. 6";
        raspuns2Array[19] = "b. 5";
        raspuns3Array[19] = "c. 8";
        raspuns4Array[19] = "d. 9";
        raspunsuriArray[19] = 1;

        intrebariArray[20] = "Variabilele x, y și z sunt de tip întreg și memorează numere naturale din intervalul [1, 1000]. Indicați o expresie C/C++ care are valoarea 1 dacă și numai dacă valoarea variabilei x este strict mai mare decât valoarea oricăreia dintre variabilele y și z.";
        raspuns1Array[20] = "a. x * z > x * y && y * z > y * x";
        raspuns2Array[20] = "b. y * z > x * z && y * x > z * x";
        raspuns3Array[20] = "c. y * z > y * x && y * z > z * x";
        raspuns4Array[20] = "d. x * y > y * z && x * z > y * z";
        raspunsuriArray[20] = 4;

        intrebariArray[21] = "Variabilele i şi j sunt de tip întreg, iar variabila m memorează un tablou bidimensional cu 5 linii şi 5 coloane, numerotate de la 0 la 4, cu elemente numere întregi. O expresie C/C++ a cărei valoare este egală cu produsul dintre primul element de pe linia i și ultimul element de pe coloana j din acest tablou este:";
        raspuns1Array[21] = "a. m[i][0]*m[4][j]";
        raspuns2Array[21] = "b. m[0,i]*m[j,4]";
        raspuns3Array[21] = "c. m(i)(0)*m(4)(j)";
        raspuns4Array[21] = "d. m(0,i)*m(j,4)";
        raspunsuriArray[21] = 1;

        intrebariArray[22] = "Indicați șirul afișat pe ecran în urma executării instrucțiunii următoare:" + "\n" + "cout << strstr(\"veni,vidi,vici\",\"vi\");";
        raspuns1Array[22] = "a. 2";
        raspuns2Array[22] = "b. vidi";
        raspuns3Array[22] = "c. vidi,vici";
        raspuns4Array[22] = "d. 6";
        raspunsuriArray[22] = 3;

        intrebariArray[23] = "Într-un arbore cu rădăcină considerăm că un nod se află pe nivelul x dacă lanţul elementar care are o extremitate în nodul respectiv şi cealaltă extremitate în rădăcina arborelui are lungimea x. Pe nivelul 0 se află un singur nod (rădăcina). Pe fiecare nivel nenul al unui arbore cu rădăcină există cel puțin o frunză. Dacă ultimul nivel este 3, atunci numărul minim de noduri din arbore este:";
        raspuns1Array[23] = "a. 8";
        raspuns2Array[23] = "b. 7";
        raspuns3Array[23] = "c. 6";
        raspuns4Array[23] = "d. 5";
        raspunsuriArray[23] = 3;

        intrebariArray[24] = "Un arbore cu 9 noduri, numerotate de la 1 la 9, este reprezentat prin vectorul de „taţi” (5,4,6,0,3,2,6,9,7). Rădăcina arborelui este:";
        raspuns1Array[24] = "a. 6";
        raspuns2Array[24] = "b. 7";
        raspuns3Array[24] = "c. 4";
        raspuns4Array[24] = "d. 1";
        raspunsuriArray[24] = 3;

        intrebariArray[25] = "Indicaţi expresia C/C++ care are valoarea 1 dacă şi numai dacă numărul natural memorat în variabila întreagă x are exact trei cifre.";
        raspuns1Array[25] = "a. x%1000==0 && x%100!=0";
        raspuns2Array[25] = "b. x/1000==0 && x/100!=0";
        raspuns3Array[25] = "c. x/1000==0 || x/100!=0";
        raspuns4Array[25] = "d. x%1000==0 || x%100!=0";
        raspunsuriArray[25] = 2;

        intrebariArray[26] = "Intr-un arbore cu 50 de noduri, numerotate de la 1 la 50, rădăcina este nodul 1, iar tatăl oricărui alt nod i al său este nodul numerotat cu [i/2]. Lungimea lanţului cu o extremitate în nodul 14 și cealaltă extremitate în nodul 47 este:";
        raspuns1Array[26] = "a. 8";
        raspuns2Array[26] = "b. 33";
        raspuns3Array[26] = "c. 16";
        raspuns4Array[26] = "d. 5";
        raspunsuriArray[26] = 1;

        intrebariArray[27] = "Indicaţi o expresie C/C++ care are valoarea 1 dacă şi numai dacă numărul natural memorat în variabila întreagă x are exact o cifră.";
        raspuns1Array[27] = "a. x%10==x/10";
        raspuns2Array[27] = "b. x%10==x";
        raspuns3Array[27] = "c. (x%10)/10==x";
        raspuns4Array[27] = "d. x/10==x";
        raspunsuriArray[27] = 2;

        intrebariArray[28] = "Variabila s permite accesarea unui șir de maximum 49 de caractere. Indicați expresia egală cu 1 dacă și numai dacă șirul 2017 coincide cu subșirul format din primele patru caractere ale șirului accesat prin variabila s și NU mai apare pe alte poziții în acesta.";
        raspuns1Array[28] = "a. strstr(s,”2017”)==s && strstr(s+4,”2017”)==0";
        raspuns2Array[28] = "b. strstr(s,”2017”)==0 && strstr(s+4,”2017”)==s+4";
        raspuns3Array[28] = "c. strstr(s,”2017”)!=s || strstr(s+4,”2017”)!=s+4";
        raspuns4Array[28] = "d. strstr(s,”2017”)!=0 || strstr(s+4,”2017”)!=0";
        raspunsuriArray[28] = 1;

        intrebariArray[29] = "Utilizând metoda backtracking se generează, în ordine crescătoare, toate numerele naturale pare cu trei cifre, cu proprietatea că nu există două cifre egale alăturate și suma cifrelor este 10. Primele cinci numere generate sunt, în această ordine: 136, 154, 172, 190, 208. Al şaselea număr generat este:";
        raspuns1Array[29] = "a. 217";
        raspuns2Array[29] = "b. 226";
        raspuns3Array[29] = "c. 262";
        raspuns4Array[29] = "d. 280";
        raspunsuriArray[29] = 3;

        intrebariArray[30] = "Se consideră un graf neorientat cu 6 noduri şi 9 muchii. Numărul de muchii ce trebuie adăugate, pentru ca graful obtinut să fie complet, este:";
        raspuns1Array[30] = "a. 5";
        raspuns2Array[30] = "b. 12";
        raspuns3Array[30] = "c. 6";
        raspuns4Array[30] = "d. 15";
        raspunsuriArray[30] = 3;

        intrebariArray[31] = "Indicati care dintre expresiile C/C++ de mai jos are valoarea 1 dacă şi numai dacă numărul natural memorat în variabila întreagă n este divizibil cu 2 şi cu 7.";
        raspuns1Array[31] = "a. (n%2==0) || !(n%7==0)";
        raspuns2Array[31] = "b. (n%7==2) && (n%2==7)";
        raspuns3Array[31] = "c. !( (n%2==1) || (n%7!=0))";
        raspuns4Array[31] = "d. (n%2==0) && (n%7!=0)";
        raspunsuriArray[31] = 3;

        intrebariArray[32] = "Utilizând metoda backtracking se generează toate numerele pare cu câte trei cifre, cifre care apartin multimii {7, 8, 1, 6, 2, 3}. Primele 4 solutii generate sunt, în această ordine: 778, 776, 772, 788. Cea de a 8-a solutie generată este:";
        raspuns1Array[32] = "a. 782";
        raspuns2Array[32] = "b. 712";
        raspuns3Array[32] = "c. 718";
        raspuns4Array[32] = "d. 716";
        raspunsuriArray[32] = 4;

        intrebariArray[33] = "Indicati care dintre expresiile C/C++ de mai jos are valoarea 1 dacă şi numai dacă numărul memorat în variabila întreagă x apartine reuniunii de intervale [-3,-1]∪[1,3].";
        raspuns1Array[33] = "a. x>=-3 && x<=-1 && x>=1 && x<=3";
        raspuns2Array[33] = "b. !(x<-3 || x>-1) || !(x<1 || x>3)";
        raspuns3Array[33] = "c. x>=-3 || x<=-1 || x>=1 || x<=3";
        raspuns4Array[33] = "d. !(x<-3 && x>3 && x>-1 || x<1)";
        raspunsuriArray[33] = 2;

        intrebariArray[34] = "Numim pădure un graf neorientat în care fiecare componentă conexă a sa este un arbore. Orice pădure cu cel putin doi arbori este un graf care:";
        raspuns1Array[34] = "a. nu are cicluri şi este conex";
        raspuns2Array[34] = "b. nu are cicluri şi nu este conex";
        raspuns3Array[34] = "c. are cicluri şi este conex";
        raspuns4Array[34] = "d. are cicluri şi nu este conex";
        raspunsuriArray[34] = 3;

        intrebariArray[35] = "Se consideră definite trei variabile de tip int: x, y şi z. O expresie C/C++ care are valoarea 1 dacă şi numai dacă x, y şi z au valori identice este:";
        raspuns1Array[35] = "a. x==y || x==z || y==z";
        raspuns2Array[35] = "b. !( x!=y && x!=z)";
        raspuns3Array[35] = "c. x==y && x==z";
        raspuns4Array[35] = "d. x==y==z";
        raspunsuriArray[35] = 3;

        intrebariArray[36] = "Variabilele x, y și z sunt de tip întreg și memorează câte un număr natural nenul. Dacă expresia C/C++: !(z<=y) && y>x are valoarea 1, indicați șirul crescător format cu valorile acestor variabile, în ordinea precizată mai jos.";
        raspuns1Array[36] = "a. x, y, z";
        raspuns2Array[36] = "b. y, z, x";
        raspuns3Array[36] = "c. z, x, y";
        raspuns4Array[36] = "d. z, y, x";
        raspunsuriArray[36] = 1;

        intrebariArray[37] = "Se consideră un graf neorientat complet, cu 9 noduri. Pentru a obține un graf parțial al său cu două componente conexe, fiecare dintre acestea fiind grafuri complete, numărul maxim de muchii care pot fi eliminate este:";
        raspuns1Array[37] = "a. 20";
        raspuns2Array[37] = "b. 18";
        raspuns3Array[37] = "c. 24";
        raspuns4Array[37] = "d. 14";
        raspunsuriArray[37] = 1;

        intrebariArray[38] = "Variabila x este de tip întreg și poate memora un număr natural cu cel mult două cifre. Valoarea maximă pe care o poate avea expresia C/C++: x%7 este:";
        raspuns1Array[38] = "a. 14.14";
        raspuns2Array[38] = "b. 6";
        raspuns3Array[38] = "c. 693";
        raspuns4Array[38] = "d. 93";
        raspunsuriArray[38] = 2;

        intrebariArray[39] = "Valoarea expresiei C/C++: 5*9/2*3 este:";
        raspuns1Array[39] = "a. 7";
        raspuns2Array[39] = "b. 66";
        raspuns3Array[39] = "c. 67.5";
        raspuns4Array[39] = "d. 7.5";
        raspunsuriArray[39] = 2;

        intrebariArray[40] = "Posibilitățile de a forma succesiuni de câte 5 genuri muzicale distincte din mulțimea {jazz, rock, latino, house, pop}, astfel încât în fiecare succesiune genul latino precede genul house. Două succesiuni sunt distincte dacă genurile muzicale sunt în altă ordine. Primele cinci soluţii generate sunt, în această ordine, (jazz, rock, latino, house, pop), (jazz, rock, latino, pop, house), (jazz, rock, pop, latino, house), (jazz, latino, rock, house, pop), (jazz, latino, rock, pop, house). Imediat înainte de (pop, latino, house, jazz, rock) este generată soluția:";
        raspuns1Array[40] = "a. (pop, rock, latino, house, jazz)";
        raspuns2Array[40] = "b. (pop, latino, rock, house, jazz)";
        raspuns3Array[40] = "c. (rock, jazz, house, latino, pop)";
        raspuns4Array[40] = "d. (rock, jazz, latino, house, pop)";
        raspunsuriArray[40] = 2;

        intrebariArray[41] = "Un arbore cu 4 noduri, numerotate de la 1 la 4, NU poate fi reprezentat prin vectorul de „taţi”:";
        raspuns1Array[41] = "a. (2,1,0,3)";
        raspuns2Array[41] = "b. (4,4,4,0)";
        raspuns3Array[41] = "c. (2,3,4,0)";
        raspuns4Array[41] = "d. (0,1,2,3)";
        raspunsuriArray[41] = 1;

        intrebariArray[42] = "Se consideră un graf neorientat conex şi fără cicluri, în care gradul oricărui nod este mai mic sau egal cu 4. Dacă șase dintre nodurile sale au gradul egal cu 1, atunci numărul maxim de noduri cu gradul egal cu 4 este:";
        raspuns1Array[42] = "a. 0";
        raspuns2Array[42] = "b. 1";
        raspuns3Array[42] = "c. 2";
        raspuns4Array[42] = "d. 3";
        raspunsuriArray[42] = 4;

        intrebariArray[43] = "Indicaţi expresia C/C++ care are valoarea 1 dacă şi numai dacă cifra zecilor numărului natural memorat în variabila întreagă n este 2 sau 7.";
        raspuns1Array[43] = "a. (n%10)/10==2 || (n%10)/10==7";
        raspuns2Array[43] = "b. (n%10)/10==2 && (n%10)/10==7";
        raspuns3Array[43] = "c. (n/10)%10==2 && (n/10)%10==7";
        raspuns4Array[43] = "d. (n/10)%10==2 || (n/10)%10==7";
        raspunsuriArray[43] = 4;

        intrebariArray[44] = "Un arbore cu 4 noduri, numerotate de la 1 la 4, poate fi reprezentat prin vectorul de „taţi”:";
        raspuns1Array[44] = "a. (4,3,4,0)";
        raspuns2Array[44] = "b. (4,3,2,1)";
        raspuns3Array[44] = "c. (2,1,0,3)";
        raspuns4Array[44] = "d. (2,0,3,1)";
        raspunsuriArray[44] = 1;

        intrebariArray[45] = "Utilizând metoda backtracking, se generează toate aranjamentele florale de câte 5 flori distincte din mulţimea {frezie, iris, lalea, mac, nard}. Două aranjamente sunt distincte dacă florile sunt dispuse în altă ordine. Primele patru soluţii obţinute sunt, în această ordine: (frezie, iris, lalea, mac, nard), (frezie, iris, lalea, nard, mac), (frezie, iris, mac, lalea, nard), (frezie, iris, mac, nard, lalea). A cincea soluție generată este:";
        raspuns1Array[45] = "a. (frezie, lalea, iris, mac, nard)";
        raspuns2Array[45] = "b. (frezie, lalea, iris, nard, mac)";
        raspuns3Array[45] = "c. (frezie, iris, nard, lalea, mac)";
        raspuns4Array[45] = "d. (frezie, iris, nard, mac, lalea)";
        raspunsuriArray[45] = 3;

        intrebariArray[46] = "Valoarea expresiei C/C++: 42/10*29/10 este:";
        raspuns1Array[46] = "a. 11";
        raspuns2Array[46] = "b. 6";
        raspuns3Array[46] = "c. 18";
        raspuns4Array[46] = "d. 8";
        raspunsuriArray[46] = 1;

        intrebariArray[47] = "Pentru a putea memora un tablou bidimensional cu maximum 21 de elemente, numere reale, variabila A se poate declara astfel:";
        raspuns1Array[47] = "a. A[3][7] float;";
        raspuns2Array[47] = "b. int A[3;7];";
        raspuns3Array[47] = "c. float A[3][7];";
        raspuns4Array[47] = "d. A[3..7] int;";
        raspunsuriArray[47] = 3;

        intrebariArray[48] = "Utilizând metoda backtracking, se generează toate posibilitățile de a obține suma 4 cu numere naturale nenule. Două sume sunt distincte dacă diferă prin cel puțin un termen. Soluţiile generate sunt, în această ordine, 1+1+1+1, 1+1+2, 1+3, 2+2. Aplicând același algoritm pentru a genera toate posibilitățile de a obține suma 6, dacă prima soluție generată este 1+1+1+1+1+1, atunci soluția 1+2+3 este generată:";
        raspuns1Array[48] = "a. a 9-a";
        raspuns2Array[48] = "b. a 8-a";
        raspuns3Array[48] = "c. a 7-a";
        raspuns4Array[48] = "d. a 6-a";
        raspunsuriArray[48] = 4;

        intrebariArray[49] = "Variabila x este de tip întreg şi memorează un număr natural. Expresia: ((x%5+1)%5+1)%5 are valoarea 0 dacă şi numai dacă expresia x%5 are valoarea:";
        raspuns1Array[49] = "a. 4";
        raspuns2Array[49] = "b. 3";
        raspuns3Array[49] = "c. 1";
        raspuns4Array[49] = "d. 2";
        raspunsuriArray[49] = 2;

        intrebariArray[50] = "Indicaţi expresia care are valoarea 1 dacă şi numai dacă numărul memorat în variabila întreagă x aparţine mulţimii {1,2,3}.";
        raspuns1Array[50] = "a. !( x<=1 || x>=3 )";
        raspuns2Array[50] = "b. !( x<=1 && x>=3 )";
        raspuns3Array[50] = "c. x==1 || x==2 || x==3";
        raspuns4Array[50] = "d. x==1 && x==2 && x==3";
        raspunsuriArray[50] = 3;
    }

    public void startGame()
    {
        answer5Button.setVisibility(View.INVISIBLE);
        int numberRandom = new Random().nextInt((50 - 1) + 1) + 1;;
        while(numberRandom == nrAux)
        {
            numberRandom = new Random().nextInt((50 - 1) + 1) + 1;
        }
        textView2.setText(intrebariArray[numberRandom]);
        answer1Button.setText(raspuns1Array[numberRandom]);
        answer2Button.setText(raspuns2Array[numberRandom]);
        answer3Button.setText(raspuns3Array[numberRandom]);
        answer4Button.setText(raspuns4Array[numberRandom]);
        nrAux = numberRandom;
        numarVerificareRaspuns = raspunsuriArray[numberRandom];
    }
    public void goBackToMain()
    {
        finish();
    }

}