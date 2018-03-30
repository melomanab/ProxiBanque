package service;


/**
 * @author HEDI Ines, MORENO Beatriz
 *
 */
public interface IOperationsBancaires {
	
	/**
	 * @param montant
	 * @return
	 * Interface des methodes crediter et debiter
	 */
	public boolean crediter(double montant);
	public boolean debiter(double montant);

}
