package tpguides.service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import tpguides.model.Guide;
import tpguides.model.Role;
import tpguides.model.User;
import tpguides.repository.GuideRepository;
import tpguides.repository.RoleRepository;
import tpguides.repository.UserRepository;

import java.util.Arrays;
import java.util.Set;

@Component
public class DataInitializer implements CommandLineRunner {

    private final GuideRepository guideRepository;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public DataInitializer(GuideRepository guideRepository, UserRepository userRepository, RoleRepository roleRepository) {
        this.guideRepository = guideRepository;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        if (guideRepository.count() == 0) {
            Guide guide1 = new Guide();
            guide1.setTitle("Draven Tutorial");
            guide1.setDescription("How to master Draven in League of Legends");
            guide1.setGame("League of Legends");
            guide1.setTags(Arrays.asList("ADC", "Draven", "Mechanics", "Overon"));

            // Beispiel 2: Briars Feet
            Guide guide2 = new Guide();
            guide2.setTitle("Briars Feet");
            guide2.setDescription("A detailed Guide about Briars Feet");
            guide2.setGame("League of Legends");
            guide2.setTags(Arrays.asList("Champion lore", "Briar", "lildio"));

            // Beispiel 3: Jett Guide
            Guide guide3 = new Guide();
            guide3.setTitle("Jett Guide");
            guide3.setDescription("Complete guide to Jett in Valorant");
            guide3.setGame("Valorant");
            guide3.setTags(Arrays.asList("Agent", "Jett", "Gameplay"));

            // Beispiel 4: Counter-Strike 2 Strategies
            Guide guide4 = new Guide();
            guide4.setTitle("Counter-Strike 2 Strategies");
            guide4.setDescription("Top strategies for Counter-Strike 2");
            guide4.setGame("Counter-Strike");
            guide4.setTags(Arrays.asList("Strategy", "CS2", "Tactics", "GrafGrafowitz"));

            // Beispiel 5: Inferno Smokes
            Guide guide5 = new Guide();
            guide5.setTitle("Inferno Smokes");
            guide5.setDescription("Effective smokes in CS:GO's Inferno map");
            guide5.setGame("Counter-Strike");
            guide5.setTags(Arrays.asList("Smokes", "Inferno", "CSGO", "Skywalker"));

            // Beispiel 6: Breeze Smokes
            Guide guide6 = new Guide();
            guide6.setTitle("Breeze Smokes");
            guide6.setDescription("Smokes for Breeze in Valorant");
            guide6.setGame("Valorant");
            guide6.setTags(Arrays.asList("Smokes", "Breeze", "Utility"));


            // usw....
            Guide guide7 = new Guide();
            guide7.setTitle("Mastering ADC in LoL");
            guide7.setDescription("A guide to becoming a top-tier ADC in League of Legends");
            guide7.setGame("League of Legends");
            guide7.setTags(Arrays.asList("ADC", "Positioning", "Mechanics", "League"));

            Guide guide8 = new Guide();
            guide8.setTitle("Valorant Agent Guide: Phoenix");
            guide8.setDescription("Everything you need to know to play Phoenix in Valorant");
            guide8.setGame("Valorant");
            guide8.setTags(Arrays.asList("Phoenix", "Agent", "Valorant", "Gameplay"));

            Guide guide9 = new Guide();
            guide9.setTitle("CS:GO Tactics: Dust 2");
            guide9.setDescription("The ultimate guide to strategies on Dust 2 in CS:GO");
            guide9.setGame("Counter-Strike");
            guide9.setTags(Arrays.asList("Tactics", "Dust 2", "CSGO", "Strategy"));

            Guide guide10 = new Guide();
            guide10.setTitle("Jett Smokes and Utility");
            guide10.setDescription("How to use Jett’s smokes and utility in Valorant effectively");
            guide10.setGame("Valorant");
            guide10.setTags(Arrays.asList("Jett", "Utility", "Smokes", "Valorant"));

            Guide guide11 = new Guide();
            guide11.setTitle("CS2: Advanced Smokes");
            guide11.setDescription("Advanced smoke strategies for CS2 maps");
            guide11.setGame("Counter-Strike");
            guide11.setTags(Arrays.asList("Smokes", "Advanced", "Strategy", "CS2"));

            Guide guide12 = new Guide();
            guide12.setTitle("Briar Lore and Gameplay");
            guide12.setDescription("Understanding Briar’s backstory and her gameplay in LoL");
            guide12.setGame("League of Legends");
            guide12.setTags(Arrays.asList("Lore", "Champion", "Briar", "Gameplay"));


            // Speichern der Guides
            guideRepository.save(guide1);
            guideRepository.save(guide2);
            guideRepository.save(guide3);
            guideRepository.save(guide4);
            guideRepository.save(guide5);
            guideRepository.save(guide6);
            guideRepository.save(guide7);
            guideRepository.save(guide8);
            guideRepository.save(guide9);
            guideRepository.save(guide10);
            guideRepository.save(guide11);
            guideRepository.save(guide12);
        }

        // Rollen initialisieren
        if (roleRepository.count() == 0) {
            Role adminRole = new Role("ADMIN");
            Role modRole = new Role("MOD");
            Role userRole = new Role("USER");
            roleRepository.save(adminRole);
            roleRepository.save(modRole);
            roleRepository.save(userRole);
        }

        // Benutzer initialisieren
        if (userRepository.count() == 0) {
            Role adminRole = roleRepository.findByName("ADMIN");
            Role userRole = roleRepository.findByName("USER");

            User admin = new User("admin", "admin123", "admin@admin.de", Set.of(adminRole, userRole));
            User user = new User("user", "user123", "user@user.de", Set.of(userRole));

            userRepository.save(admin);
            userRepository.save(user);
        }
    }
}