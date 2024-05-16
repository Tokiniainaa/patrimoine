package school.hei.patrimoine.possession;

import lombok.Getter;
import school.hei.patrimoine.NotImplemented;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Getter
public final class TrainDeVie extends Possession {
  private final Instant debut;
  private final Instant fin;
  private final int depensesMensuelle;
  private final Argent financePar;
  private final int dateDePonction;

  public TrainDeVie(
      String nom,
      int depensesMensuelle,
      Instant debut,
      Instant fin,
      Argent financePar,
      int dateDePonction) {
    super(nom, debut, financePar.valeurComptable);
    this.debut = debut;
    this.fin = fin;
    this.depensesMensuelle = depensesMensuelle;
    this.dateDePonction = dateDePonction;

    this.financePar = financePar;
    this.financePar.addFinancés(this);
  }

  @Override
  public TrainDeVie projectionFuture(Instant tFutur) {
    long nbMois = debut.until(tFutur, ChronoUnit.MONTHS);
    int depensesTotales = depensesMensuelle * (int) nbMois;
    int valeurFuture = valeurComptable-depensesTotales;
    Argent argent = new Argent(nom,t,valeurFuture);
return new TrainDeVie(
        nom,
        depensesMensuelle,
        debut,
        fin,
        argent,
        dateDePonction
);

  }
}
