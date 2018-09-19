package pl.coderslab.receiver.model;

import javax.persistence.*;
import java.text.DecimalFormat;

@Entity
@Table(name = "wallets")
public class Wallet
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Double balance;
    @OneToOne
    private User user;
}
