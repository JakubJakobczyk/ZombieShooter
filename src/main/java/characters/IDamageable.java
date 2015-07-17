package characters;

/**
 * Created by T540p on 2015-05-21.
 */
public interface IDamageable {

    boolean dealDmg(int damage);

    boolean death();

    boolean heal(int heal_amount);

}
