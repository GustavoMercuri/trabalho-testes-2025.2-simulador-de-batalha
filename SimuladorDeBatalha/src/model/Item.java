package model;

public class Item {

	public void aplicaItem(String nome, Criatura criatura) {
		switch (nome) {
		case "antidoto":
			if (criatura.getStatus() == "envenenado") {
				criatura.setStatus("normal");
			}
			break;
		case "pocaoCura":
			int cura = 10;
			if (criatura.getVida() < criatura.getVidaMax()) {
				if (criatura.getVida() + cura > criatura.getVidaMax()) {
					criatura.setVida(criatura.getVidaMax());
				} else {
					criatura.setVida(criatura.getVida() + cura);
				}
			}
			break;
		}
	}
}
