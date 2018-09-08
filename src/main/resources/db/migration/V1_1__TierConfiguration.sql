/**
 * Author:  Gavin Boshoff
 * Created: Sep 8, 2018
 */
CREATE TABLE tier_configuration
(
    country VARCHAR(20) NOT NULL,
    band_lower_bound INT NOT NULL,
    band_upper_bound INT,
    band_percentage INT NOT NULL,
    PRIMARY KEY (country, band_lower_bound)
);

INSERT INTO tier_configuration (country, band_lower_bound, band_upper_bound, band_percentage)
VALUES ('ZA', 0, 5000, 0);
INSERT INTO tier_configuration (country, band_lower_bound, band_upper_bound, band_percentage)
VALUES ('ZA', 5000, 20000, 20);
INSERT INTO tier_configuration (country, band_lower_bound, band_percentage)
VALUES ('ZA', 20000, 40);
