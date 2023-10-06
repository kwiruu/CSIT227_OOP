About pull requests
In this article

    About pull requests
    Draft pull requests
    Differences between commits on compare and pull request pages
    Further reading

Pull requests let you tell others about changes you've pushed to a branch in a repository on GitHub. Once a pull request is opened, you can discuss and review the potential changes with collaborators and add follow-up commits before your changes are merged into the base branch.
Platform navigation

    Mac
    Windows
    Linux

About pull requests

Note: When working with pull requests, keep the following in mind:

    If you're working in the shared repository model, we recommend that you use a topic branch for your pull request. While you can send pull requests from any branch or commit, with a topic branch you can push follow-up commits if you need to update your proposed changes.
    Be very careful when force pushing commits to a pull request. Force pushing changes the repository history and can corrupt your pull request. If other collaborators branch the project before a force push, the force push may overwrite commits that collaborators based their work on.

You can create pull requests on GitHub.com, with GitHub Desktop, in GitHub Codespaces, on GitHub Mobile, and when using GitHub CLI.

After initializing a pull request, you'll see a review page that shows a high-level overview of the changes between your branch (the compare branch) and the repository's base branch. You can add a summary of the proposed changes, review the changes made by commits, add labels, milestones, and assignees, and @mention individual contributors or teams. For more information, see "Creating a pull request."

Once you've created a pull request, you can push commits from your topic branch to add them to your existing pull request. These commits will appear in chronological order within your pull request and the changes will be visible in the "Files changed" tab.

Other contributors can review your proposed changes, add review comments, contribute to the pull request discussion, and even add commits to the pull request. By default, in public repositories, any user can submit reviews that approve or request changes to a pull request. Organization owners and repository admins can limit who is able to give approving pull request reviews or request changes. For more information, see "Managing pull request reviews in your organization" and "Managing pull request reviews in your repository."

You can see information about the branch's current deployment status and past deployment activity on the "Conversation" tab. For more information, see "Viewing deployment activity for your repository."

After you're happy with the proposed changes, you can merge the pull request. If you're working in a shared repository model, you create a pull request and you, or someone else, will merge your changes from your feature branch into the base branch you specify in your pull request. For more information, see "Merging a pull request."

If status checks are required for a repository, the required status checks must pass before you can merge your branch into the protected branch. For more information, see "About protected branches."

You can link a pull request to an issue to show that a fix is in progress and to automatically close the issue when someone merges the pull request. For more information, see "Linking a pull request to an issue."

Tips:

    To toggle between collapsing and expanding all outdated review comments in a pull request, hold down Alt and click Show outdated or Hide outdated. For more shortcuts, see "Keyboard shortcuts."
    You can squash commits when merging a pull request to gain a more streamlined view of changes. For more information, see "About pull request merges."

You can visit your dashboard to quickly find links to recently updated pull requests you're working on or subscribed to. For more information, see "About your personal dashboard."
Draft pull requests

Draft pull requests are available in public repositories with GitHub Free for organizations and legacy per-repository billing plans, and in public and private repositories with GitHub Team, GitHub Enterprise Server, and GitHub Enterprise Cloud. For more information, see "GitHub’s plans."

When you create a pull request, you can choose to create a pull request that is ready for review or a draft pull request. Draft pull requests cannot be merged, and code owners are not automatically requested to review draft pull requests. For more information about creating a draft pull request, see "Creating a pull request" and "Creating a pull request from a fork."

When you're ready to get feedback on your pull request, you can mark your draft pull request as ready for review. Marking a pull request as ready for review will request reviews from any code owners. You can convert a pull request to a draft at any time. For more information, see "Changing the stage of a pull request."
Differences between commits on compare and pull request pages

The compare and pull request pages use different methods to calculate the diff for changed files:

    Compare pages show the diff between the tip of the head ref and the current common ancestor (that is, the merge base) of the head and base ref.
    Pull request pages show the diff between the tip of the head ref and the common ancestor of the head and base ref at the time when the pull request was created. Consequently, the merge base used for the comparison might be different.
