public class Gitter {
    private Zelle[][] gitter;
    final int GITTERSIZEX, GITTERSIZEY;

    Gitter(int GitterSizeX, int GitterSizey, boolean rmd) {
        GITTERSIZEX = GitterSizeX;
        GITTERSIZEY = GitterSizey;
        gitter = new Zelle[GITTERSIZEX][GITTERSIZEY];

        for (int i = 0; i < GITTERSIZEX; i++) {
            for (int k = 0; k < GITTERSIZEY; k++) {
                if(rmd)
                    gitter[i][k] = new Zelle(i, k);
                if(!rmd)
                    gitter [i][k] = new Zelle(i, k, false);

            }

        }
    }

    public void setZelle(int x, int y, boolean zustand)
    {
        if(x < GITTERSIZEX && x >= 0
        && y < GITTERSIZEY && y >= 0)
        gitter[x][y].setZustand(zustand);
    }

    public void lebenOderSterben(Zelle z) {
        int nachbar = 0;

        //links oben
        if (gitter[z.getX() - 1][z.getY() + 1].getZustand() == true) {
            nachbar = nachbar + 1;
        }

        //einen drüber
        if (gitter[z.getX()][z.getY() + 1].getZustand() == true) {
            nachbar = nachbar + 1;
        }

        //rechts oben
        if (gitter[z.getX() + 1][z.getY() + 1].getZustand() == true) {
            nachbar = nachbar + 1;
        }

        //einen links
        if (gitter[z.getX() - 1][z.getY()].getZustand() == true) {
            nachbar = nachbar + 1;
        }

        //einen rechts
        if (gitter[z.getX() + 1][z.getY()].getZustand() == true) {
            nachbar = nachbar + 1;
        }

        //links unten
        if (gitter[z.getX() - 1][z.getY() - 1].getZustand() == true) {
            nachbar = nachbar + 1;
        }

        //einen drunter
        if (gitter[z.getX()][z.getY() - 1].getZustand() == true) {
            nachbar = nachbar + 1;
        }

        //rechts unten
        if (gitter[z.getX() + 1][z.getY() - 1].getZustand() == true) {
            nachbar = nachbar + 1;
        }


        if (z.getZustand() == true) {

            if (nachbar == 3 || nachbar == 2) {
                z.setZustand(true);
            }
            if (nachbar < 2) {
                z.setZustand(false);
            }
            if (nachbar > 3) {
                z.setZustand(false);
            }

        } else {
            if (nachbar == 3) {
                z.setZustand(true);
            }
        }

    }

    /**
     *
     */
    public void nextGeneration() {
        // Zelle[][] GitternextGeneration = new Zelle[52][52];
        for (int i = 1; i < GITTERSIZEX - 1; i++) {
            for (int k = 1; k < GITTERSIZEY - 1; k++) {
                lebenOderSterben(gitter[i][k]);

            }
        }
    }

    public void print() {
        for (int i = 0; i < GITTERSIZEY; i++) {
            for (int k = 0; k < GITTERSIZEX; k++) {
                System.out.print(gitter[k][i]);
            }
            System.out.print("\n");
        }
    }

}
