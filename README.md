Im going to teach you how to set the backend of RC-PORMS in intellij.

These are the steps:
1. Go to the repository of rc-porms.

   ![image](https://github.com/RoCS2024/rc-porms/assets/150970652/b92969bf-8bf1-472d-a969-ec9c473fff02)

2. Click the code button and then copy the https link of the repo.

  ![image](https://github.com/RoCS2024/rc-porms/assets/150970652/7540ee8c-8f6a-453f-8188-08338da02cba)

3. Go to your git folder and execute the command git bash here.

  ![image](https://github.com/RoCS2024/rc-porms/assets/150970652/d3f91c26-507b-4db4-857c-98df3147f88d)

4. Then in the command prompt, you're going to the the command git clone and paste the link you have copied.

   ![image](https://github.com/RoCS2024/rc-porms/assets/150970652/a4c97048-6f64-4f5d-a541-2c127d2aa1e9)

5. Hit enter and it should initialize the command.

   ![image](https://github.com/RoCS2024/rc-porms/assets/150970652/2390cade-acb6-44f6-bd08-094895916f03)

   and after that, this folder should appear:
   
   ![image](https://github.com/RoCS2024/rc-porms/assets/150970652/334fa01c-59c8-47b2-a110-e0bfb0214ddd)

6. Open the Intellij on your machine.

   ![image](https://github.com/RoCS2024/rc-porms/assets/150970652/3c519ecf-9483-48c8-8e95-40fff0011509)

7. Then click the open project button.

   ![image](https://github.com/RoCS2024/rc-porms/assets/150970652/aa3d6aab-0860-44ca-acf5-32c33a650c3b)

8. Find the folder that you have cloned.

   ![image](https://github.com/RoCS2024/rc-porms/assets/150970652/0b784f3d-2c8f-4721-b560-df6eec45c38d)

9. After opening the file, there will be suggestions in your lower left, you can just ignore that.

    ![image](https://github.com/RoCS2024/rc-porms/assets/150970652/3b5a67c5-9189-4a36-a42e-805326efcd1c)

10. Now we are going to set the application in order for the application to work. Go to settings in the file tab.

    ![image](https://github.com/RoCS2024/rc-porms/assets/150970652/41453325-0e9c-48d8-aaaa-362814e6ca5e)

11. Now in the settings, find the Build, Execution, Deployment tab.

    ![image](https://github.com/RoCS2024/rc-porms/assets/150970652/289db84b-bf52-4e9e-9f58-d7fdbfb8cae4)

12. Once your in, find the build tools.

    ![image](https://github.com/RoCS2024/rc-porms/assets/150970652/5f9f74e7-395b-4989-8c66-ccb5292d7760)

13. Change it to any changes then click apply and ok.

    ![image](https://github.com/RoCS2024/rc-porms/assets/150970652/10512ab9-0f19-43d0-b450-c06096a7da88)

    ![image](https://github.com/RoCS2024/rc-porms/assets/150970652/c905ac2a-f52a-4a7c-8dbb-79be6b825e23)


15. Go to file tab again but now go to project structure.

    ![image](https://github.com/RoCS2024/rc-porms/assets/150970652/6e70a40f-321c-4001-91fd-f88c2539241c)

16. It will take you to the project page, you should see that there are no sdk configured. So you will select the sdk 17.

    ![image](https://github.com/RoCS2024/rc-porms/assets/150970652/79a3ce72-8bca-4889-8782-840bbf614362)

    ![image](https://github.com/RoCS2024/rc-porms/assets/150970652/fe6e3268-e73c-46aa-9952-78fe49678a68)

    then set the language level to 17 also:

    ![image](https://github.com/RoCS2024/rc-porms/assets/150970652/b212794a-9439-4f4d-8c50-54424ba8e805)

    then click apply and ok.

18. Go to project structure again but go to the module page and it should look like this:

    ![image](https://github.com/RoCS2024/rc-porms/assets/150970652/f50eacae-de72-4f4f-a826-640b607e8468)

19. Delete the "main" and "test" module by selecting the individual module and clicking the "-" button.

    ![image](https://github.com/RoCS2024/rc-porms/assets/150970652/bf62ab30-8bc1-4632-bb7f-e641c5d33404)

    ![image](https://github.com/RoCS2024/rc-porms/assets/150970652/34b48094-0ca2-446d-98da-7d0b8adcf77d)

20. After that, click on the rc-porms module and click the "+" button.

    ![image](https://github.com/RoCS2024/rc-porms/assets/150970652/2425cedb-ad65-4bd7-932c-c52e246912fa)

21. Click the IvyIdea.

    ![image](https://github.com/RoCS2024/rc-porms/assets/150970652/55b1d9e0-e944-4c56-a9c7-1401bc470b86)

22. It should look like this:

    ![image](https://github.com/RoCS2024/rc-porms/assets/150970652/fe5a7ac5-f109-42c6-884f-d0ad23a3697e)

23. find the ivy.xml file in this module :

    ![image](https://github.com/RoCS2024/rc-porms/assets/150970652/f0f62bc4-f47e-40fe-b649-735bf413ace6)

    ![image](https://github.com/RoCS2024/rc-porms/assets/150970652/0655cc2b-6f58-4646-987f-ece099e17955)

    ![image](https://github.com/RoCS2024/rc-porms/assets/150970652/02475f57-c1ca-4da8-ad89-6536933a16f9)

    then below it, you'll see this menu:

    ![image](https://github.com/RoCS2024/rc-porms/assets/150970652/2c0e2554-1197-4616-bdab-56feebdcdfc7)

    check the box and select the option " use ivy default " then click apply and ok.

24. go to your project and right click, a menu will appear and select ivy idea, then select the resolve for rc-porms module.

    ![image](https://github.com/RoCS2024/rc-porms/assets/150970652/8e2a4bc6-22ea-4d7f-b9d7-baac6f1d2a7b)

25. Wait for it to load and after loading you should see the folder IvyIDEA below the external libraries.

    ![image](https://github.com/RoCS2024/rc-porms/assets/150970652/aa9d757b-10fb-4ad7-8b2c-802fbdf38f39)

26. Next is go to src folder and you will see 2 folders, main and test folder. under the main and test folder, there is a folder
    named java. the java folder under the main will mark directory as the source root, while the java folder under the test will be
    marked as a test sources root.

    ![image](https://github.com/RoCS2024/rc-porms/assets/150970652/45d45249-86b4-401c-89ce-a38fca6309bc)

    ![image](https://github.com/RoCS2024/rc-porms/assets/150970652/897b6c5e-0605-4479-ae63-90a48518ba97)

    after that, in the main folder there is another directory called resources and we will mark it as resources root.

    ![image](https://github.com/RoCS2024/rc-porms/assets/150970652/c75dd0e3-a703-4e4c-9605-623c530b4610)

    it should look like this after marking it:

    ![image](https://github.com/RoCS2024/rc-porms/assets/150970652/26882359-a60f-4a5c-8a31-ac6d79404b36)

27. Then you're all set.




    


    





    








    



    




    



    



   





   




